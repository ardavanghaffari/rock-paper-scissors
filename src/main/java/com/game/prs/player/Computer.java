package com.game.prs.player;

import com.game.prs.PrsGame;

public class Computer extends Player {
  @Override
  public void chooseWeapon(PrsGame game) {
    setWeapon(game.getWeaponFactory().create());
    game.getUserInterface().display(String.format("%s chose: %s", this, getWeapon()));
  }

  @Override
  public String toString() {
    return "The computer";
  }
}
