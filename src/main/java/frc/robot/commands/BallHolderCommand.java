package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class BallHolderCommand extends Command{

    public BallHolderCommand() {
        requires(Robot.basketSystem);
    }

    @Override
    protected void initialize() {
    }
  
    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (Robot.basketSystem.isBallHolderTripped() && !Robot.basketSystem.isHoldingBall()) {
            Robot.basketSystem.ballHolderClose();
            Robot.basketSystem.setHoldingBall(true);
        }
        /*
        else if (!Robot.basketSystem.isBallHolderTripped() && Robot.basketSystem.isHoldingBall()) {
            Robot.basketSystem.ballHolderOpen();
            Robot.basketSystem.setHoldingBall(false);
        }
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
}
