/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase 
{

  private WPI_TalonSRX left, right, leftFollow, rightFollow;
  private DifferentialDrive myDrive;
  private AHRS navx;
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() 
  {
    left = new WPI_TalonSRX(Constants.leftMotor);
    left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    right = new WPI_TalonSRX(Constants.rightMotor);
    right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);


    //follower drive motors
    leftFollow = new WPI_TalonSRX(Constants.leftFollowMotor);
    rightFollow = new WPI_TalonSRX(Constants.rightFollowMotor);

    leftFollow.follow(left);
    rightFollow.follow(right);

    myDrive = new DifferentialDrive(left, right);

    try
    {
      navx = new AHRS(Constants.navxPort);
    }
    catch (RuntimeException ex ) 
    {
      DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
    }
  }

  public void aDrive(double speed, double rotate)
  {
    myDrive.arcadeDrive(speed, rotate);
  }

  public void setMaxOutput(double v) 
  {

  }

  public double getTurnRate() 
  {
    return navx.getRate();
  }

  public double getHeading() 
  {
    return navx.getYaw();
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
