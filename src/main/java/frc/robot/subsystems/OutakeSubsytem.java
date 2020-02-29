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

public class OutakeSubsytem extends SubsystemBase {
  /**
   * Creates a new OutakeSubsytem.
   */
  private WPI_VictorSPX outtake_motor;
  public OutakeSubsytem() {
      outtake_motor = new WPI_VictorSPX(Constants.outtake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void run_outtake(double speed)
  {
    outtake_motor.set(ControlMode.PercentOutput, speed);
  }
}
