/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class EncoderSubSystem extends Subsystem {
  private WPI_TalonSRX encoderMotor;
  Encoder encoder;

  public EncoderSubSystem(){
    encoderMotor = new WPI_TalonSRX(8);
    encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void drive(double speed){
    encoderMotor.set(speed);
  }
  public int readEncoder(){
    return encoder.get();
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
