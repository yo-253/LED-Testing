// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.led;

import static frc.robot.subsystems.led.LEDConstants.*;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
  private final AddressableLED led;
  private final AddressableLEDBuffer ledBuffer;

  private int colorIndex = 0;

  public LEDSubsystem() {
    led = new AddressableLED(port);

    ledBuffer = new AddressableLEDBuffer(LEDLength);
    led.setLength(ledBuffer.getLength());

    led.setData(ledBuffer);
    led.start();
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
    led.setData(ledBuffer);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void start() {
    led.start();
  }

  public void stop() {
    led.stop();
  }

  public void setPattern(LEDPattern pattern) {
    pattern.applyTo(ledBuffer);
  }

  public void solidColor(Color color) {
    LEDPattern solid = LEDPattern.solid(color);
    setPattern(solid);
  }

  public void nextColor(boolean reverse) {
    if (!reverse) {
      colorIndex++;
    } else {
      colorIndex--;
    }
    
    solidColor(Color.fromHSV((int) (Math.PI / 6 * colorIndex), 255, 255));
  }
}
