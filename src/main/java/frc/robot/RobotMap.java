/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static int rightMotor1 = 0;
  public static int rightMotor2 = 1;
  public static int leftMotor1 = 2;
  public static int leftMotor2 = 3;

  public static int elbowLeftMotor = 4;
  public static int elbowRightMotor = 5;

  public static int wristMotor = 6;

  public static int intakeMotor = 7;

  public static int frontRightLegLiftMotor = 8;
  public static int frontLeftLegLiftMotor = 9;
  public static int rearLegLiftMotor = 10;
  public static int frontRightLegDriveMotor = 11;
  public static int frontLeftLegDriveMotor = 12;

  public static int frontRightLegTopLimitSwitch = 0;
  public static int frontRightLegBottomLimitSwitch = 1;

  public static int frontLeftLegTopLimitSwitch = 2;
  public static int frontLeftLegBottomLimitSwitch = 3;

  public static int rearLegTopLimitSwitch = 4;
  public static int rearLegBottomLimitSwitch = 5;

  public static int driveShifterSolenoid = 0;
  public static int hatchPanelSolenoid = 1;

}
