package com.game.prs.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScissorTest {
  @Test
  public void testBeat() {
    Weapon weapon = mock(Weapon.class);
    when(weapon.beatScissor()).thenReturn(1);

    Scissor Scissor = new Scissor();

    assertEquals(-1, Scissor.beat(weapon));
  }

  @Test
  public void testBeatPaper() {
    assertEquals(1, new Scissor().beatPaper());
  }

  @Test
  public void testBeatRock() {
    assertEquals(-1, new Scissor().beatRock());
  }

  @Test
  public void testBeatScissor() {
    assertEquals(0, new Scissor().beatScissor());
  }
}