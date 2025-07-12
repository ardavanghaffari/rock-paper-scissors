package com.game.rps.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaperTest {

    private Paper paper;

    @BeforeEach
    void setUp() {
        paper = new Paper();
    }

    @Test
    void testBeat() {
        Weapon weapon = mock(Weapon.class);
        when(weapon.beatPaper()).thenReturn(1);
        assertEquals(-1, paper.beat(weapon));
    }

    @Test
    void testBeatPaper() {
        assertEquals(0, paper.beatPaper());
    }

    @Test
    void testBeatRock() {
        assertEquals(1, paper.beatRock());
    }

    @Test
    void testBeatScissor() {
        assertEquals(-1, paper.beatScissor());
    }

}
