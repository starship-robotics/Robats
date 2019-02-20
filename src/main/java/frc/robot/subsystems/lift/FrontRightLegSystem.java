package frc.robot.subsystems.lift;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;


public class FrontRightLegSystem extends LegSystem {

    public FrontRightLegSystem() {
        super();
        this.liftMotor = new WPI_TalonSRX(RobotMap.frontRightLegLiftMotor);
        this.driveMotor = new WPI_TalonSRX(RobotMap.frontRightLegDriveMotor);
        this.topLimitSwitch = new DigitalInput(RobotMap.frontRightLegTopLimitSwitch);
        this.bottomLimitSwitch = new DigitalInput(RobotMap.frontRightLegBottomLimitSwitch);
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