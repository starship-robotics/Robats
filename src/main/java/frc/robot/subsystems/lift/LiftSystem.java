package frc.robot.subsystems.lift;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSystem extends Subsystem {

    public static final double FRONT_LIFT_UP_MULTIPLIER = .7;
    public static final double FRONT_RIGHT_UP_MULTIPLIER = .74;
    public static final double REAR_LIFT_UP_MULTIPLIER = .99;
    public static final double FRONT_LIFT_DOWN_MULTIPLIER = .6;
    public static final double REAR_LIFT_DOWN_MULTIPLIER = .5;
    
    private FrontLeftLegSystem frontLeftLegSystem;
    private FrontRightLegSystem frontRightLegSystem;
    private RearLegSystem rearLegSystem;

    public LiftSystem(FrontLeftLegSystem frontLeftLegSystem,
            FrontRightLegSystem frontRightLegSystem,
            RearLegSystem rearLegSystem) {
        super();
        this.frontLeftLegSystem = frontLeftLegSystem;
        this.frontRightLegSystem = frontRightLegSystem;
        this.rearLegSystem = rearLegSystem;
    }

    @Override
    protected void initDefaultCommand() {

    }

    


}