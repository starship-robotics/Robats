package frc.robot.subsystems.arm;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class WristSystem extends Subsystem {

    protected WPI_TalonSRX wristMotor;

    public WristSystem(){
        this.wristMotor = new WPI_TalonSRX(RobotMap.wristMotor);
    }

    public void drive(double speed){
        wristMotor.set(speed);
    }

    public int encoderValue(){
        return wristMotor.getSensorCollection().getQuadraturePosition();
    }

    public boolean isTopSwitchTripped() {
        return wristMotor.getSensorCollection().isFwdLimitSwitchClosed();
    }

    public boolean isBottomSwitchTripped() {
        return wristMotor.getSensorCollection().isRevLimitSwitchClosed();
    }

    @Override
    protected void initDefaultCommand() {
    }

}