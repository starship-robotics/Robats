package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class HatchDownCommand extends Command{

    boolean finished = false;

    public HatchDownCommand() {
        requires(Robot.hatchSystem);
    }

    @Override
    protected void initialize() {
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.hatchSystem.openArm();
        finished = true;
    }
  
    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
      return finished;
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
