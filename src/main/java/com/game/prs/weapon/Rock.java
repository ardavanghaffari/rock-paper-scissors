package com.game.prs.weapon;

public class Rock implements Weapon {
  @Override
  public int beat(Weapon weapon) {
    return -weapon.beatRock();
  }
  @Override
  public int beatPaper() {
    return -1;
  }
  @Override
  public int beatRock() {
    return 0;
  }
  @Override
  public int beatScissor() {
    return 1;
  }
  @Override
  public String toString() {
    return "Rock";
  }
}
