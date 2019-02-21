package frc.robot.subsystems.lift;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;


public class FrontLeftLegSystem extends LegSystem {

    public FrontLeftLegSystem() {
        super();
        this.liftMotor = new WPI_TalonSRX(RobotMap.frontLeftLegLiftMotor);
        this.driveMotor = new WPI_TalonSRX(RobotMap.frontLeftLegDriveMotor);
        this.topLimitSwitch = new DigitalInput(RobotMap.frontLeftLegTopLimitSwitch);
        this.bottomLimitSwitch = new DigitalInput(RobotMap.frontLeftLegBottomLimitSwitch);
    }

    @Override
    protected void initDefaultCommand() {
    }

    @Override
    public void driveLift(double speed) {
        if (speed > 0) {
            speed = speed * LiftSystem.FRONT_LIFT_DOWN_MULTIPLIER;
        } else {
            speed = speed * LiftSystem.FRONT_LIFT_UP_MULTIPLIER;
        }
        liftMotor.set(speed);
    }

    @Override
    public void driveWheels(double speed){
        driveMotor.set(speed);
    }

}