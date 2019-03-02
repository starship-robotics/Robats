/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;


public class DriveTrain extends Subsystem {

  private WPI_TalonSRX rightTalon1, rightTalon2, leftTalon1, leftTalon2;
  private DifferentialDrive drive;
  private DoubleSolenoid gearShifter;

  public DriveTrain() {

    rightTalon1 = new WPI_TalonSRX(RobotMap.rightMotor1);
    rightTalon2 = new WPI_TalonSRX(RobotMap.rightMotor2);

    leftTalon1 = new WPI_TalonSRX(RobotMap.leftMotor1);
    leftTalon2 = new WPI_TalonSRX(RobotMap.leftMotor2);

    SpeedControllerGroup leftMotor = new SpeedControllerGroup(leftTalon1, leftTalon2);
    SpeedControllerGroup rightMotor = new SpeedControllerGroup(rightTalon1, rightTalon2);

    drive = new DifferentialDrive(leftMotor, rightMotor);

    gearShifter = new DoubleSolenoid(RobotMap.driveShifterSolenoidHigh, RobotMap.driveShifterSolenoidLow);
    gearShifter.set(Value.kOff);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed, true);
  }

  public void arcadeDrive(double speed, double zRotation){
    drive.arcadeDrive(speed, zRotation);
  }

  public void switchToHighGear() {
    gearShifter.set(Value.kForward);
  }

  public void switchToLowGear() {
    gearShifter.set(Value.kReverse);
  }

  public boolean isHighGear() {
    return gearShifter.get() == Value.kForward;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
