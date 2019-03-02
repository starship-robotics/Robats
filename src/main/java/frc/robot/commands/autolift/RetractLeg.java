package frc.robot.commands.autolift;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.lift.LegSystem;


public class RetractLeg extends Command {

    private LegSystem legSystem;
    private boolean shouldRampSpeed = false;
    private Timer timer;
    private int time;

    public RetractLeg(LegSystem legSystem, int time) {
        super();
        this.legSystem = legSystem;
        this.time = time;
        requires(legSystem);
    }

    @Override
    protected void initialize() {
        timer = new Timer();
        timer.start();
    }

    @Override
    protected void execute() {
        // speed 1 should be lifting robot
        double speed = 1;
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
    }

    private double rampingSpeed(double speed) {
        final int RAMP_CONSTANT = 8;
        // don't have to worry about direction as we only ramp if it's lifting and that should be a positive number
        double currentMotorSpeed = legSystem.getLiftMotorSpeed();
        return currentMotorSpeed + ((speed - currentMotorSpeed) / RAMP_CONSTANT);
    }

    @Override
    protected boolean isFinished() {
        return timer.get() > time;
    }

    @Override
    protected void end() {
        legSystem.driveLift(0);
    }

    @Override
    protected void interrupted() {
    }

}
