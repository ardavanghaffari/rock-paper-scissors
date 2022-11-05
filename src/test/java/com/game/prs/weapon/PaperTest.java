package com.game.prs.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaperTest {
  @Test
  public void testBeat() {
    Weapon weapon = mock(Weapon.class);
    when(weapon.beatPaper()).thenReturn(1);

    Paper paper = new Paper();

    assertEquals(-1, paper.beat(weapon));
  }

  @Test
  public void testBeatPaper() {
    assertEquals(0, new Paper().beatPaper());
  }

  @Test
  public void testBeatRock() {
    assertEquals(1, new Paper().beatRock());
  }

  @Test
  public void testBeatScissor() {
    assertEquals(-1, new Paper().beatScissor());
  }
}
