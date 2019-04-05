package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.lift.LegSystem;


public class LiftDriveCommand extends Command {

    private LegSystem legSystem;
    private boolean maintainLift = false;

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
        double speed = Robot.oi.getJoy1TriggerLeft() * -1;
        if (speed == 0) {
            speed = Robot.oi.getJoy1TriggerRight();
        }

        if ((legSystem.isTopSwitchTripped() && speed > 0)
            || (legSystem.isBottomSwitchTripped() && speed < 0)
            || (!legSystem.isTopSwitchTripped() && !legSystem.isBottomSwitchTripped())) {

            // Ramping if needed... to smooth out keeping robot lifted
            if (speed < 0 && maintainLift) {
                // Lift is going down... turn off ramping
                maintainLift = false;
            }
            if (maintainLift) {
                speed = maintainLift(speed);
            }

            legSystem.driveLift(speed);
        } else {
            if (legSystem.isBottomSwitchTripped() && speed > 0) {
                // Set ramping code on as we have hit the top and direction via speed says we still want to stay lifted
                maintainLift = true;
            }
            legSystem.driveLift(0);
        }

        //legSystem.driveWheels(Robot.oi.getJoy2RightStickYAxis());
    }

    private double maintainLift(double speed) {
        return speed * .6;
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
