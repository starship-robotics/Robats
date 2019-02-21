package frc.robot.subsystems.hatch;


import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


public class HatchSystem extends Subsystem{

    DoubleSolenoid armPiston;

    public HatchSystem(){
        this.armPiston = new DoubleSolenoid(RobotMap.hatchPanelDownSolenoid, RobotMap.hatchPanelUpSolenoid);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void openArm(){
        armPiston.set(Value.kForward);        
    }

    public void closeArm(){
        armPiston.set(Value.kReverse);
    }

}