// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.led;

import static frc.robot.subsystems.led.LEDConstants.*;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
  private final PWM led;

  private int colorIndex = 0;

  public LEDSubsystem() {
    led = new PWM(port);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setColor(BlinkinValues input) {
    led.setPulseTimeMicroseconds(input.value);
  }

  public void setColor(int input) {
    led.setPulseTimeMicroseconds(input);
  }

  public int getColorValue() {
    return led.getPulseTimeMicroseconds();
  }

  public String getColorName() {
    return BlinkinValues.values()[led.getPulseTimeMicroseconds()].name();
  }

  public void start() {
    setColor(BlinkinValues.WHITE);
  }

  public void stop() {
    setColor(BlinkinValues.BLACK);
  }
}
