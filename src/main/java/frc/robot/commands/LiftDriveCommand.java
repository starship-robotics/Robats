package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.lift.LegSystem;


public class LiftDriveCommand extends Command {

    private LegSystem legSystem;
    private boolean shouldRampSpeed = false;

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
        double speed = Robot.oi.getJoy2LeftStickYAxis() * -1;
        if ((legSystem.isTopSwitchTripped() && speed > 0)
            || (legSystem.isBottomSwitchTripped() && speed < 0)
            || (!legSystem.isTopSwitchTripped() && !legSystem.isBottomSwitchTripped())) {

            // Ramping if needed... to smooth out keeping robot lifted
            if (speed < 0 && shouldRampSpeed) {
                // Lift is going down... turn off ramping
                shouldRampSpeed = false;
            }
            if (shouldRampSpeed) {
                speed = rampingSpeed(speed);
            }

            legSystem.driveLift(speed);
        } else {
            if (legSystem.isBottomSwitchTripped() && speed > 0) {
                // Set ramping code on as we have hit the top and direction via speed says we still want to stay lifted
                shouldRampSpeed = true;
            }
            legSystem.driveLift(0);
        }

        legSystem.driveWheels(Robot.oi.getJoy2RightStickYAxis());
    }

    private double rampingSpeed(double speed) {
        final int RAMP_CONSTANT = 8;
        // don't have to worry about direction as we only ramp if it's lifting and that should be a positive number
        double currentMotorSpeed = legSystem.getLiftMotorSpeed();
        return currentMotorSpeed + ((speed - currentMotorSpeed) / RAMP_CONSTANT);
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
