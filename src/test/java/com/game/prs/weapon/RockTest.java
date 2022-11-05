package com.game.prs.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RockTest {
  @Test
  public void testBeat() {
    Weapon weapon = mock(Weapon.class);
    when(weapon.beatRock()).thenReturn(1);

    Rock Rock = new Rock();

    assertEquals(-1, Rock.beat(weapon));
  }

  @Test
  public void testBeatPaper() {
    assertEquals(-1, new Rock().beatPaper());
  }

  @Test
  public void testBeatRock() {
    assertEquals(0, new Rock().beatRock());
  }

  @Test
  public void testBeatScissor() {
    assertEquals(1, new Rock().beatScissor());
  }
}