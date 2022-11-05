package com.game.prs;

import com.game.prs.player.Computer;
import com.game.prs.player.Human;
import com.game.prs.weapon.Paper;
import com.game.prs.weapon.Rock;
import com.game.prs.weapon.Scissor;
import com.game.prs.weapon.WeaponFactory;

public class PrsApplication {
  private static final int MIN_ALLOWED_ARG = 1;
  private static final int MAX_ALLOWED_ARG = 20;

  public static void main(String[] args) {
    Integer arg = parseCommandLineArgument(args);

    WeaponFactory weaponFactory = new WeaponFactory(Paper::new, Rock::new, Scissor::new);
    TextBasedUserInterface userInterface = new TextBasedUserInterface();
    PrsGame game = new PrsGame(new Human(), new Computer(), weaponFactory, userInterface, arg);

    game.play();
  }

  private static Integer parseCommandLineArgument(String[] args) {
    Integer arg = null;
    if (args.length > 0) {
      try {
        arg = Integer.parseInt(args[0]);
        if (arg < MIN_ALLOWED_ARG || arg > MAX_ALLOWED_ARG) {
          printAndExit(String.format("Paper-Rock-Scissors game can only be played between %d and %d rounds!",
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
