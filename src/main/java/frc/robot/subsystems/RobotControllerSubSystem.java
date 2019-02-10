package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class RobotControllerSubSystem extends Subsystem{



    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
      }
    public double getVoltage(){
    return RobotController.getBatteryVoltage();
    }
}
