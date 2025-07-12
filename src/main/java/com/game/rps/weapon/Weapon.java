package com.game.rps.weapon;

public interface Weapon {

    int beat(Weapon weapon);

    int beatPaper();

    int beatRock();

    int beatScissor();
}
