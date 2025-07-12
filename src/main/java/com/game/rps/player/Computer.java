package com.game.rps.player;

import com.game.rps.Game;

public class Computer extends Player {

    @Override
    public void chooseWeapon(Game game) {
        setWeapon(game.getWeaponFactory().create());
        game.getUserInterface().display(String.format("%s chose: %s", this, getWeapon()));
    }

    @Override
    public String toString() {
        return "The computer";
    }

}
