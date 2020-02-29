/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.SerialPort.Port;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 * <p>
 * It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    //Joystick
    public static int joy1_id = 0;
    public static int joy2_id = 1;

    //can id
    public static int leftMotor = 1;
    public static int leftFollowMotor = 3;
    public static int rightMotor = 2;
    public static int rightFollowMotor = 4;
    public static int intake = 5;
    public static int outtake = 6;
    public static int hook = 7;
    public static int lift = 7;

    //multiplier value
    public static double intake_speeed = 0.95;
    public static double outake_speed = 0.95;
    public static double hookup_speed = 0.5;
    public static double hookdown_speed = -0.5;
    public static double liftup_speed = 0.5;
    public static double liftdown_speed = -0.5;

    //buttons Controller 1
    public static int change_speed = 5;
    public static int drive_straight = 6;
    public static int turn_90 = 1;
    public static int turn_90_revers = 3;

    //buttons Controller 2
    public static int run_intake = 1;
    public static int run_outtake = 2;

    public static int run_hook_up = 3;
    public static int run_hook_down = 4;

    public static int run_lift_up = 5;
    public static int run_lift_down = 6;

    //Navx Port
    public static Port navxPort = Port.kUSB;

    //PID Values
    public static final double kStabilizationP = 1;
    public static final double kStabilizationI = 0.5;
    public static final double kStabilizationD = 0;

    public static final double kTurnP = 1;
    public static final double kTurnI = 0;
    public static final double kTurnD = 0;

    public static final double kTurnToleranceDeg = 5;
    public static final double kTurnRateToleranceDegPerS = 5; // degrees per second
}