package frc.robot.commands.autolift;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.lift.LegSystem;


public class LiftDriveForward extends Command {

    private LegSystem legSystem;
    private Timer timer;
    private int time;

    public LiftDriveForward(LegSystem legSystem, int time) {
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
        legSystem.driveWheels(-1);
    }

    @Override
    protected boolean isFinished() {
        return timer.get() > time;
    }

    @Override
    protected void end() {
        legSystem.driveWheels(0);
    }

    @Override
    protected void interrupted() {
    }

}
