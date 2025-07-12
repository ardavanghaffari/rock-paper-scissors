package com.game.rps.player;

import com.game.rps.weapon.WeaponFactory;
import com.game.rps.Game;
import com.game.rps.TextBasedUserInterface;
import com.game.rps.weapon.Weapon;

import java.util.List;
import java.util.stream.IntStream;

public class Human extends Player {

    @Override
    public void chooseWeapon(Game game) {
        TextBasedUserInterface ui = game.getUserInterface();
        WeaponFactory factory = game.getWeaponFactory();

        int option = getWeaponOption(factory.getAllWeapons(), ui);

        setWeapon(factory.create(option - 1));
        ui.display(String.format("%s chose: %s", this, getWeapon()));
    }

    private int getWeaponOption(List<Weapon> weapons, TextBasedUserInterface ui) {
        ui.display("Choose your weapon:");

        IntStream.range(0, weapons.size())
                .forEach((i -> ui.display((i + 1) + "- " + weapons.get(i))));

        while (true) {
            try {
                ui.display("Your choice: ", false);

                int option = Integer.parseInt(ui.readUserInput());
                if (option < 1 || option > weapons.size()) {
                    ui.display(String.format("Enter a number between 1 and %d", weapons.size()));
                    continue;
                }

                ui.displayEmptyLine();

                return option;
            } catch (NumberFormatException e) {
                ui.display("Invalid input, Enter a number!");
            }
        }
    }

    @Override
    public String toString() {
        return "You";
    }

}
