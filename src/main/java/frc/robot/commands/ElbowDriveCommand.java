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
        if (Robot.elbowSystem.isTopSwitchActive() || Robot.elbowSystem.isBottomSwitchActive()) {
            Robot.elbowSystem.drive(0);
        } else {
            Robot.elbowSystem.drive(speed);
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
