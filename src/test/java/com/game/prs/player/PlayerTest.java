package com.game.prs.player;

import com.game.prs.PrsGame;
import com.game.prs.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {
  @Mock
  Weapon selfWeapon;
  @Mock
  Weapon otherWeapon;

  Player other;
  Player self;

  @BeforeEach
  public void setup() {
    self = new PlayerDouble();
    other = new PlayerDouble();
    self.setWeapon(selfWeapon);
    other.setWeapon(otherWeapon);
  }

  @Test
  public void testChallengeSelfWins() {
    when(selfWeapon.beat(any(Weapon.class))).thenReturn(1);

    int result = self.challenge(other);

    assertEquals(1, self.getScore());
    assertEquals(0, other.getScore());
    assertEquals(1, result);
  }

  @Test
  public void testChallengeOtherWins() {
    when(selfWeapon.beat(any(Weapon.class))).thenReturn(-1);

    int result = self.challenge(other);

    assertEquals(0, self.getScore());
    assertEquals(1, other.getScore());
    assertEquals(-1, result);
  }

  @Test
  public void testChallengeDraw() {
    when(selfWeapon.beat(any(Weapon.class))).thenReturn(0);

    int result = self.challenge(other);

    assertEquals(0, self.getScore());
    assertEquals(0, other.getScore());
    assertEquals(0, result);
  }

  public class PlayerDouble extends Player {
    @Override
    public void chooseWeapon(PrsGame game) {}
  }
}
