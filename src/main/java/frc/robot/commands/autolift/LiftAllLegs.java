package frc.robot.commands.autolift;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.lift.LegSystem;


public class LiftAllLegs extends Command {

    private LegSystem legSystem;
    private boolean maintainLift = false;
    private Timer timer;
    private int time;

    public LiftAllLegs(LegSystem legSystem, int time) {
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
        double speed = -1;
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
    }

    private double maintainLift(double speed) {
        return speed * .6;
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
