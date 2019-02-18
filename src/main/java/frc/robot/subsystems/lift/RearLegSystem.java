package frc.robot.subsystems.lift;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;


public class RearLegSystem extends LegSystem {

    public RearLegSystem() {
        super();
        this.liftMotor = new WPI_TalonSRX(RobotMap.rearLegLiftMotor);
        this.topLimitSwitch = new DigitalInput(RobotMap.rearLegTopLimitSwitch);
        this.bottomLimitSwitch = new DigitalInput(RobotMap.rearLegBottomLimitSwitch);
    }

    @Override
    protected void initDefaultCommand() {
    }

    @Override
    public void driveLift(double speed) {
        if (speed < 0) {
            speed = speed * LiftSystem.REAR_LIFT_DOWN_MULTIPLIER;
        } else {
            speed = speed * LiftSystem.REAR_LIFT_UP_MULTIPLIER;
        }
        liftMotor.set(speed);
    }

}