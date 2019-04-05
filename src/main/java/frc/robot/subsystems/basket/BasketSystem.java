package frc.robot.subsystems.basket;


import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BasketSystem extends Subsystem {

    private DoubleSolenoid armPiston;
    private DoubleSolenoid ballHolder;
    private DigitalInput ballHolderSwitch;
    private boolean isHoldingBall = false;

    public BasketSystem() {
        this.armPiston = new DoubleSolenoid(RobotMap.ballBasketDownSolenoid, RobotMap.ballBasketUpSolenoid);
        this.ballHolder = new DoubleSolenoid(1, RobotMap.ballHolderSolenoidOpen, RobotMap.ballHolderSolenoidClose);
        this.ballHolderSwitch = new DigitalInput(RobotMap.ballHolderSwitch);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void basketUp() {
        armPiston.set(Value.kForward);
    }

    public void basketDown() {
        armPiston.set(Value.kReverse);
    }

    public void ballHolderOpen() {
        ballHolder.set(Value.kForward);
    }

    public void ballHolderClose() {
        ballHolder.set(Value.kReverse);
    }

    public boolean isBallHolderTripped() {
        return !ballHolderSwitch.get();
    }

    public boolean isHoldingBall() {
        return isHoldingBall;
    }

    public void setHoldingBall(boolean holdingBall) {
        isHoldingBall = holdingBall;
    }
}