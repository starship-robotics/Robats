/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class EncoderDriveCommand extends Command {

  private NetworkTableInstance networkTableInstance;
  private NetworkTableEntry tableEntry;

  public EncoderDriveCommand(NetworkTableInstance networkTableInstance) {
    // Use requires() here to declare subsystem dependencies
    this.networkTableInstance = networkTableInstance;
    NetworkTable networkTable = networkTableInstance.getTable("SmartDashboard");
    // requires(Robot.encoder);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double speed = Robot.m_oi.getJoy1TriggerLeft();
    //Robot.encoder.drive(speed);
    if (speed != 0) {
      // SmartDashboard.putString("EncoderValue", Robot.encoder.readEncoder() + "");
    }
    //System.out.println(""+Robot.encoder.readEncoder());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
