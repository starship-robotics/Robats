package frc.robot.subsystems.lift;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class LegSystem extends Subsystem {

    WPI_TalonSRX liftMotor, driveMotor;
    DigitalInput topLimitSwitch;
    DigitalInput bottomLimitSwitch;

    LegSystem() {
        super();
    }

    @Override
    protected void initDefaultCommand() {
    }
    
    public void driveLift(double speed) {
    }

    public void driveWheels(double speed) {
    }

    public boolean isTopSwitchTripped() {
        return !topLimitSwitch.get();
    }

    public boolean isBottomSwitchTripped() {
        return !bottomLimitSwitch.get();
    }

    public double getLiftMotorSpeed() {
        return liftMotor.get();
    }
    
}