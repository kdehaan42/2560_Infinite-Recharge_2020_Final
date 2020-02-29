/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LfitSubsystem extends SubsystemBase {
  /**
   * Creates a new LfitSubsystem.
   */
  private  WPI_VictorSPX hook_motor;
  private  WPI_VictorSPX lift_motor;

  public LfitSubsystem() {
    hook_motor = new WPI_VictorSPX(Constants.hook);
    lift_motor = new WPI_VictorSPX(Constants.lift);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void move_hook(double speed) {
    hook_motor.set(ControlMode.PercentOutput, speed);
  }

  public  void move_lift(double speed)
  {
    lift_motor.set(ControlMode.PercentOutput, speed);
  }


}
