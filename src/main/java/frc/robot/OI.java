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
  private Joystick controller2;
  private Button controller1ButtonA;
  private Button controller1ButtonB;
  private Button controller1ButtonX;
  private Button controller1ButtonY;
  private Button controller1ButtonLB;
  private Button controller1ButtonRB;

  private Button controller2ButtonA;
  private Button controller2ButtonB;
  private Button controller2ButtonX;
  private Button controller2ButtonY;
  private Button controller2ButtonLB;
  private Button controller2ButtonRB;
  private double deadZone = .15d;

  public OI(){
    controller1 = new Joystick(0);
    controller1ButtonA = new JoystickButton(controller1, 1);
    controller1ButtonB = new JoystickButton(controller1, 2);
    controller1ButtonX = new JoystickButton(controller1, 3);
    controller1ButtonY = new JoystickButton(controller1, 4);
    controller1ButtonLB = new JoystickButton(controller1, 5);
    controller1ButtonRB = new JoystickButton(controller1, 6);
    
    controller2 = new Joystick(1);
    controller2ButtonA = new JoystickButton(controller2, 1);
    controller2ButtonB = new JoystickButton(controller2, 2);
    controller2ButtonX = new JoystickButton(controller2, 3);
    controller2ButtonY = new JoystickButton(controller2, 4);
    controller2ButtonLB = new JoystickButton(controller2, 5);
    controller2ButtonRB = new JoystickButton(controller2, 6);
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
  
  public Button getJoy1ButtonB(){
    return controller1ButtonB;
  }
  public Button getJoy1ButtonX(){
    return controller1ButtonX;
  }
  public Button getJoy1ButtonY(){
    return controller1ButtonY;
  }
  public Button getJoy1ButtonLB(){
    return controller1ButtonLB;
  }
  public Button getJoy1ButtonRB(){
    return controller1ButtonRB;
  }
  //-------------------------------
  public double getJoy2LeftStickYAxis(){
    if(Math.abs(controller2.getRawAxis(1)) > deadZone){
      return controller2.getRawAxis(1);
    } else{
      return 0;
    }

  }

  public double getJoy2RightStickYAxis(){
    if(Math.abs(controller2.getRawAxis(5)) > deadZone){
      return controller2.getRawAxis(5);
    } else{
      return 0;
    }

  }

  public double getJoy2TriggerLeft(){
    if(Math.abs(controller2.getRawAxis(2)) > deadZone){
      return controller2.getRawAxis(2);
    } else{
      return 0;
    }

  }

  public double getJoy2TriggerRight(){
    if(Math.abs(controller2.getRawAxis(3)) > deadZone){
      return controller2.getRawAxis(3);
    } else{
      return 0;
    }

  }


  public Button getJoy2ButtonA(){
    return controller1ButtonA;
  }
  
  public Button getJoy2ButtonB(){
    return controller1ButtonB;
  }
  public Button getJoy2ButtonX(){
    return controller1ButtonX;
  }
  public Button getJoy2ButtonY(){
    return controller1ButtonY;
  }
  public Button getJoy2ButtonLB(){
    return controller1ButtonLB;
  }
  public Button getJoy2ButtonRB(){
    return controller1ButtonRB;
  }




}
