/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private Joystick controller1;
  private Button controller1ButtonA;
  
  private double deadZone = .15d;

  public OI(){
    controller1 = new Joystick(0);
    controller1ButtonA = new JoystickButton(controller1, 1);
  }

  public double getJoy1LeftStickYAxis(){
    if(Math.abs(controller1.getRawAxis(1)) > deadZone){
      return controller1.getRawAxis(1);
    } else{
      return 0;
    }

  }

  public double getJoy1RightStickYAxis(){
    if(Math.abs(controller1.getRawAxis(5)) > deadZone){
      return controller1.getRawAxis(5);
    } else{
      return 0;
    }

  }

  public double getJoy1TriggerLeft(){
    if(Math.abs(controller1.getRawAxis(2)) > deadZone){
      return controller1.getRawAxis(2);
    } else{
      return 0;
    }

  }

  public double getJoy1TriggerRight(){
    if(Math.abs(controller1.getRawAxis(3)) > deadZone){
      return controller1.getRawAxis(3);
    } else{
      return 0;
    }

  }


  public Button getJoy1ButtonA(){
    return controller1ButtonA;
  }


}
