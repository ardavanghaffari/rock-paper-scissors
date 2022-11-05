package com.game.prs.player;

import com.game.prs.PrsGame;
import com.game.prs.weapon.Weapon;

public abstract class Player {
  private int score;
  private Weapon weapon;
  public abstract void chooseWeapon(PrsGame game);

  public int getScore() {
    return score;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public int challenge(Player other) {
    int result = weapon.beat(other.getWeapon());
    if (result > 0) {
      this.updateScore(result);
    } else {
      other.updateScore(-result);
    }
    return result;
  }

  private void updateScore(int score) {
    this.score += score;
  }
}
