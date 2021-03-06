/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveCommand extends Command {
  public DriveCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.driveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // Arcade Drive
    Robot.driveTrain.arcadeDrive(Robot.oi.getJoy1LeftStickYAxis() * -1, Robot.oi.getJoy1RightStickXAxis() * .635);


    /*1
    // Tank Drive
    double speed1 = Robot.oi.getJoy1LeftStickYAxis();
    double speed2 = Robot.oi.getJoy1RightStickYAxis();

    double factor = .75;
    if (Robot.driveTrain.isHighGear() 
        || (Math.abs(speed1) > .75 && this.isNearlySame(speed1, speed2) )) {
      factor = 1;
    }

    speed1 = speed1 * factor; //* Robot.oi.getJoy1LeftStickYAxis();
    speed2 = speed2 * factor; // * Robot.oi.getJoy1RightStickYAxis();
    Robot.driveTrain.tankDrive(speed1 * -1, speed2 * -1);
    */
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

  private boolean isNearlySame(double speed1, double speed2) {
    double diff = speed1 - speed2;
    if (Math.abs(diff) < .1) {
      return true;
    }
    return false;
  }
}
