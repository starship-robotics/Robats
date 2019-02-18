package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.lift.LegSystem;


public class LiftDriveCommand extends Command {

    LegSystem legSystem;

    public LiftDriveCommand(LegSystem legSystem) {
        super();
        this.legSystem = legSystem;
        requires(legSystem);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        double speed = Robot.m_oi.getJoy1LeftStickYAxis() * -1;
        if ((legSystem.isTopSwitchTripped() && speed > 0)
            || (legSystem.isBottomSwitchTripped() && speed < 0)
            || (!legSystem.isTopSwitchTripped() && !legSystem.isBottomSwitchTripped())) {
            legSystem.driveLift(speed);
        } else {
            legSystem.driveLift(0);
        }

        legSystem.driveWheels(Robot.m_oi.getJoy1RightStickYAxis());
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
