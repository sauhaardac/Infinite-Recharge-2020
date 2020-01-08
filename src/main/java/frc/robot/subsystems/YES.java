/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.oo;


public class YES extends SubsystemBase {
  /**
   * Creates a new YES.
   */
  private final TalonSRX left = new TalonSRX(2);
  private final TalonSRX right = new TalonSRX(3);
  private static YES yes;
  private Joystick leftJoy;
  private Joystick rightJoy;
  
  public YES() {
    leftJoy = new Joystick(2);
    rightJoy = new Joystick(3);

    //this.setDefaultCommand(new oo());
  }
  public static YES getYes() {
    if (yes == null) {
      yes = new YES();
    }
    return yes;
  }
  public void tankDrive(double l, double r) {
    left.set(ControlMode.PercentOutput, l);
    right.set(ControlMode.PercentOutput, r);
  }

  @Override
  public void periodic() {
    tankDrive(leftJoy.getRawAxis(1), leftJoy.getRawAxis(5));
    // This method will be called once per scheduler run
  }
}
