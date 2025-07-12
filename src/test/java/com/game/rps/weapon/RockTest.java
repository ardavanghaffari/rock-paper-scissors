package com.game.rps.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RockTest {

    private Rock rock;

    @BeforeEach
    void setUp() {
        rock = new Rock();
    }

    @Test
    void testBeat() {
        Weapon weapon = mock(Weapon.class);
        when(weapon.beatRock()).thenReturn(1);
        assertEquals(-1, rock.beat(weapon));
    }

    @Test
    void testBeatPaper() {
        assertEquals(-1, rock.beatPaper());
    }

    @Test
    void testBeatRock() {
        assertEquals(0, rock.beatRock());
    }

    @Test
    void testBeatScissor() {
        assertEquals(1, rock.beatScissor());
    }

}
