package frc.robot.subsystems.lift;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


public class LegSystem extends Subsystem {

    protected WPI_TalonSRX liftMotor, driveMotor;
    protected DigitalInput topLimitSwitch;
    protected DigitalInput bottomLimitSwitch;

    @Override
    protected void initDefaultCommand() {
    }

    public void driveLift(double speed) {
    }

    public boolean isTopSwitchTripped() {
        return !topLimitSwitch.get();
    }

    public boolean isBottomSwitchTripped() {
        return !bottomLimitSwitch.get();
    }
    
}