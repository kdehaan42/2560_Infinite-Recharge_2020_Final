package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DefaultDriveCommand extends Command {
    public DefaultDriveCommand(Joystick joy1, Joystick joy2, DriveSubsystem m_robotDrive) {
        // If any subsystems are needed, you will need to pass them into the requires() method

    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        m_robotDrive.aDrive(joy1.getRawAxis(1)* -1, (joy1.getRawAxis(2)*0.8);
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
