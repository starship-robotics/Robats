package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ElbowDriveCommand extends Command {

    public ElbowDriveCommand() {
        super();
        requires(Robot.elbowSystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double speed = Robot.m_oi.getJoy1RightStickYAxis();
        if ((Robot.elbowSystem.isTopSwitchTripped() && speed > 0)
                || (Robot.elbowSystem.isBottomSwitchTripped() && speed < 0)
                || (!Robot.elbowSystem.isTopSwitchTripped() && !Robot.elbowSystem.isBottomSwitchTripped())) {
            Robot.elbowSystem.drive(speed);
        } else {
            Robot.elbowSystem.drive(0);
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
