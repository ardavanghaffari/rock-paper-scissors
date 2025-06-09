package com.game.rps;

import com.game.rps.player.Player;
import com.game.rps.weapon.WeaponFactory;

import java.util.Optional;

public class Game {
  private final static String WELCOME = "Welcome to the Paper-Rock-Scissors game!";
  private final static String SEPARATOR = "-".repeat(40);
  private final static String DRAW_MESSAGE = "It's a draw!";
  private final static String FINAL_RESULT = "*** Final Result ***";
  private final static String GOODBYE = "Thanks for playing. Goodbye!";
  private static final Integer DEFAULT_ROUNDS = 5;
  private final Integer rounds;
  private final Player player1;
  private final Player player2;
  private final WeaponFactory weaponFactory;
  private final TextBasedUserInterface userInterface;

  public WeaponFactory getWeaponFactory() {
    return weaponFactory;
  }
  public TextBasedUserInterface getUserInterface() {
    return userInterface;
  }

  public Game(Player player1, Player player2, WeaponFactory weaponFactory,
                 TextBasedUserInterface userInterface, Integer rounds) {
    this.player1 = player1;
    this.player2 = player2;
    this.weaponFactory = weaponFactory;
    this.userInterface = userInterface;
    this.rounds = (rounds == null) ? DEFAULT_ROUNDS : rounds;
  }

  public void play() {
    displayWelcomeMessage();

    int currentRound = 0;
    while (currentRound < rounds) {
      player1.chooseWeapon(this);
      player2.chooseWeapon(this);
      Player winner = challengeAndReturnWinner(player1, player2);
      displayThisRoundWinner(winner);
      currentRound++;
      displayRoundSeparator();
    }

    displayFinalResult(finalWinner());
    displayGoodByeMessage();
  }

  private Player challengeAndReturnWinner(Player p1, Player p2) {
    int result = p1.challenge(p2);
    if (result > 0) {
      return p1;
    } else if (result < 0) {
      return p2;
    } else {
      return null;
    }
  }

  private Player finalWinner() {
    if (player1.getScore() == player2.getScore()) return null;
    return player1.getScore() > player2.getScore() ?  player1 : player2;
  }

  private void displayWelcomeMessage() {
    userInterface.display(WELCOME);
    userInterface.displayEmptyLine();
  }

  private void displayThisRoundWinner(Player winner) {
    Optional.ofNullable(winner).ifPresentOrElse(
            w -> userInterface.display(String.format("%s won this round!", w)),
            this::displayDraw
    );
  }

  private void displayFinalResult(Player winner) {
    userInterface.display(FINAL_RESULT);
    Optional.ofNullable(winner).ifPresentOrElse(
            w -> userInterface.display(String.format("%s won the game!", w)),
            this::displayDraw
    );
    userInterface.display(String.format("%s scored: %d, %s scored: %d", player1, player1.getScore(), player2, player2.getScore()));
  }

  private void displayGoodByeMessage() {
    userInterface.displayEmptyLine();
    userInterface.display(GOODBYE);
  }

  private void displayDraw() {
    userInterface.display(DRAW_MESSAGE);
  }

  private void displayRoundSeparator() {
    userInterface.displayEmptyLine();
    userInterface.display(SEPARATOR);
    userInterface.displayEmptyLine();
  }
}
