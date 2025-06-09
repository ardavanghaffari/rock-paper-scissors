package com.game.rps;

import com.game.rps.player.Computer;
import com.game.rps.player.Human;
import com.game.rps.weapon.Paper;
import com.game.rps.weapon.Rock;
import com.game.rps.weapon.Scissor;
import com.game.rps.weapon.WeaponFactory;

public class Application {

  private static final int MIN_ALLOWED_ARG = 1;
  private static final int MAX_ALLOWED_ARG = 20;

  public static void main(String[] args) {
    Integer arg = parseCommandLineArgument(args);

    WeaponFactory weaponFactory = new WeaponFactory(Rock::new, Paper::new, Scissor::new);
    TextBasedUserInterface userInterface = new TextBasedUserInterface();
    Game game = new Game(new Human(), new Computer(), weaponFactory, userInterface, arg);

    game.play();
  }

  private static Integer parseCommandLineArgument(String[] args) {
    Integer arg = null;

    if (args.length > 0) {
      try {
        arg = Integer.parseInt(args[0]);

        if (arg < MIN_ALLOWED_ARG || arg > MAX_ALLOWED_ARG) {
          printAndExit(String.format(
              "Rock-Paper-Scissors game can only be played between %d and %d rounds!",
              MIN_ALLOWED_ARG, MAX_ALLOWED_ARG));
        }
      } catch (NumberFormatException e) {
        printAndExit(String.format("Argument '%s' must be a number!", args[0]));
      }
    }

    return arg;
  }

  private static void printAndExit(String message) {
    System.err.println(message);
    System.exit(1);
  }

}
