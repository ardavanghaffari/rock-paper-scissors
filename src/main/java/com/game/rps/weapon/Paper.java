package com.game.rps.weapon;

public class Paper implements Weapon {
  @Override
  public int beat(Weapon weapon) {
    return -weapon.beatPaper();
  }
  @Override
  public int beatPaper() {
    return 0;
  }
  @Override
  public int beatRock() {
    return 1;
  }
  @Override
  public int beatScissor() {
    return -1;
  }
  @Override
  public String toString() {
    return "Paper";
  }
}
