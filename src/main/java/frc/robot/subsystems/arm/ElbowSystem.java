package frc.robot.subsystems.arm;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class ElbowSystem extends Subsystem {

    WPI_TalonSRX leftMotor, rightMotor;
    SpeedControllerGroup elbowMotors;

    public ElbowSystem() {
        leftMotor = new WPI_TalonSRX(RobotMap.elbowLeftMotor);
        rightMotor = new WPI_TalonSRX(RobotMap.elbowRightMotor);
        elbowMotors = new SpeedControllerGroup(leftMotor, rightMotor);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void drive(double speed) {
        elbowMotors.set(speed);
    }

    public int encoderValue() {
        return rightMotor.getSensorCollection().getQuadraturePosition();
    }

    public boolean isTopSwitchTripped() {
        return rightMotor.getSensorCollection().isFwdLimitSwitchClosed();
    }

    public boolean isBottomSwitchTripped() {
        return rightMotor.getSensorCollection().isRevLimitSwitchClosed();
    }

}