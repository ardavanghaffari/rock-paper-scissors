package com.game.rps.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScissorTest {

  private Scissor scissor;

  @BeforeEach
  void setup() {
    scissor = new Scissor();
  }

  @Test
  void testBeat() {
    Weapon weapon = mock(Weapon.class);
    when(weapon.beatScissor()).thenReturn(1);
    assertEquals(-1, scissor.beat(weapon));
  }

  @Test
  void testBeatPaper() {
    assertEquals(1, scissor.beatPaper());
  }

  @Test
  void testBeatRock() {
    assertEquals(-1, scissor.beatRock());
  }

  @Test
  void testBeatScissor() {
    assertEquals(0, scissor.beatScissor());
  }

}
