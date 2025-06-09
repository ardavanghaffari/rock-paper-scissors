package com.game.rps.weapon;

public class Scissor implements Weapon {

  @Override
  public int beat(Weapon weapon) {
    return -weapon.beatScissor();
  }

  @Override
  public int beatPaper() {
    return 1;
  }

  @Override
  public int beatRock() {
    return -1;
  }

  @Override
  public int beatScissor() {
    return 0;
  }

  @Override
  public String toString() {
    return "Scissor";
  }

}
