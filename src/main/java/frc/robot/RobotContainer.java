/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TurnToAngleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.LfitSubsystem;
import frc.robot.subsystems.OutakeSubsytem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    private final DriveSubsystem m_robotDrive = new DriveSubsystem();
    private final IntakeSubsytem intake_sub = new IntakeSubsytem();
    private final OutakeSubsytem outake_sub = new OutakeSubsytem();
    private final LfitSubsystem lift_sub = new LfitSubsystem();

    Joystick joy1 = new Joystick(Constants.joy1_id);
    Joystick joy2 = new Joystick(Constants.joy2_id);

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();
        m_robotDrive.setMaxOutput(0.5);
        m_robotDrive.setDefaultCommand(
                //This is an inline command you can also make a whole new command if wanted
                new RunCommand(() -> m_robotDrive.aDrive(joy1.getRawAxis(1)* -1, (joy1.getRawAxis(2)*0.8)),
                m_robotDrive)
                );
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings()
    {
        //This is another inline command that calls setMaxOutput when LB is pressed
        new JoystickButton(joy1, Constants.change_speed)
                .whenPressed(()-> m_robotDrive.setMaxOutput(1))
                .whenReleased(() -> m_robotDrive.setMaxOutput(0.5));


        //Drive Straight while RB is pressed
        new JoystickButton(joy1, Constants.drive_straight).whenHeld(new PIDCommand(
                new PIDController(Constants.kStabilizationP, Constants.kStabilizationI,
                        Constants.kStabilizationD),
                // Close the loop on the turn rate
                m_robotDrive::getTurnRate,
                // Setpoint is 0
                0,
                // Pipe the output to the turning controls
                output -> m_robotDrive.aDrive(joy1.getRawAxis(1)* -1, output),
                // Require the robot drive
                m_robotDrive));


        //new POVhat(joy1).Down.whenActive((new TurnToAngleCommand(90, m_robotDrive)));        
        
        // Turn to 90 degrees when the 'X' button is pressed, with a 5 second timeout
        new JoystickButton(joy1,1).whenPressed(new TurnToAngleCommand(0, m_robotDrive).withTimeout(1));
        new JoystickButton(joy1,2).whenPressed(new TurnToAngleCommand(-90, m_robotDrive).withTimeout(1));
        new JoystickButton(joy1,4).whenPressed(new TurnToAngleCommand(90, m_robotDrive).withTimeout(1));
        new JoystickButton(joy1,3).whenPressed(new TurnToAngleCommand(-179, m_robotDrive).withTimeout(1));

        new JoystickButton(joy2, Constants.run_intake)
        .whenPressed(() -> intake_sub.run_intake(Constants.intake_speeed))
        .whenReleased(()-> intake_sub.run_intake(0));

        new JoystickButton(joy2, Constants.run_intake_rev)
        .whenPressed(() -> intake_sub.run_intake(-Constants.intake_speeed))
        .whenReleased(()-> intake_sub.run_intake(0));
        
        new JoystickButton(joy2, Constants.run_outtake)
        .whenPressed(() -> outake_sub.run_outtake(Constants.outake_speed))
        .whenReleased(()-> outake_sub.run_outtake(0));

        new JoystickButton(joy2, Constants.run_lift_up)
        .whenPressed(() -> lift_sub.move_both(Constants.hookup_speed, Constants.liftup_speed))
        .whenReleased(()-> lift_sub.move_both(0, 0));

        new JoystickButton(joy2, Constants.run_lift_down)
        .whenPressed(() -> lift_sub.move_both(Constants.hookdown_speed, Constants.liftdown_speed))
        .whenReleased(()-> lift_sub.move_both(0, 0));

        
        
        
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous
        return new TurnToAngleCommand(-90, m_robotDrive).withTimeout(5);
    }

    public DriveSubsystem getDrivSubsystem()
    {
        return m_robotDrive;
    }
}
