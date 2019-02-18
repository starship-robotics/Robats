package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class WristDriveCommand extends Command {

    public WristDriveCommand(){
        super();
        requires(Robot.wristSystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double speed = Robot.m_oi.getJoy1RightStickYAxis();
        if ((Robot.wristSystem.isTopSwitchTripped() && speed > 0)
                || (Robot.wristSystem.isBottomSwitchTripped() && speed < 0)
                || (!Robot.wristSystem.isTopSwitchTripped() && !Robot.wristSystem.isBottomSwitchTripped())) {
            Robot.wristSystem.drive(speed);
        } else {
            Robot.wristSystem.drive(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }

}
