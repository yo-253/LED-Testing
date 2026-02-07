package frc.robot;

public enum States {
  STOW(0),
  SCORE(1),
  CLIMB(2);

  public final int value;

  private States(int value) {
    this.value = value;
  }
}
