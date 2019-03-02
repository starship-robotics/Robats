package frc.robot.subsystems.basket;


import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class BasketSystem extends Subsystem{

    DoubleSolenoid armPiston;

    public BasketSystem(){
        this.armPiston = new DoubleSolenoid(RobotMap.ballBasketDownSolenoid, RobotMap.ballBasketUpSolenoid);
        this.armPiston.set(Value.kOff);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void basketUp(){
        armPiston.set(Value.kForward);        
    }

    public void basketDown(){
        armPiston.set(Value.kReverse);
    }

}