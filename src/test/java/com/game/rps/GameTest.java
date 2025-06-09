package com.game.rps;

import com.game.rps.player.Player;
import com.game.rps.weapon.WeaponFactory;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameTest {

  @Mock
  private Player player1;
  @Mock
  private Player player2;
  @Mock
  private WeaponFactory weaponFactory;
  @Mock
  private TextBasedUserInterface userInterface;

  private Game game;

  @BeforeEach
  void setup() {
    game = new Game(player1, player2, weaponFactory, userInterface, 1);
  }

  @Test
  void testPlay_WhenPlayer1Wins() {
    // given
    when(player1.challenge(player2)).thenReturn(1);
    when(player1.toString()).thenReturn("Player1");
    when(player2.toString()).thenReturn("Player2");
    when(player1.getScore()).thenReturn(1);
    when(player2.getScore()).thenReturn(0);

    // when
    game.play();

    // then
    verify(userInterface).display(eq("Welcome to the Rock-Paper-Scissors game!"));
    verify(player1).chooseWeapon(eq(game));
    verify(player2).chooseWeapon(eq(game));
    verify(player1).challenge(eq(player2));
    verify(userInterface).display(eq("Player1 won this round!"));
    verify(userInterface).display(eq("*** Final Result ***"));
    verify(userInterface).display(eq("Player1 won the game!"));
    verify(userInterface).display(eq("Player1 scored: 1, Player2 scored: 0"));
    verify(userInterface).display(eq("Thanks for playing. Goodbye!"));
  }

  @Test
  void testPlay_WhenPlayer2Wins() {
    // given
    when(player1.challenge(player2)).thenReturn(-1);
    when(player1.toString()).thenReturn("Player1");
    when(player2.toString()).thenReturn("Player2");
    when(player1.getScore()).thenReturn(0);
    when(player2.getScore()).thenReturn(1);

    // when
    game.play();

    // then
    verify(userInterface).display(eq("Welcome to the Rock-Paper-Scissors game!"));
    verify(player1).chooseWeapon(eq(game));
    verify(player2).chooseWeapon(eq(game));
    verify(player1).challenge(eq(player2));
    verify(userInterface).display(eq("Player2 won this round!"));
    verify(userInterface).display(eq("*** Final Result ***"));
    verify(userInterface).display(eq("Player2 won the game!"));
    verify(userInterface).display(eq("Player1 scored: 0, Player2 scored: 1"));
    verify(userInterface).display(eq("Thanks for playing. Goodbye!"));
  }

  @Test
  void testPlay_WhenDraw() {
    // given
    when(player1.challenge(player2)).thenReturn(0);
    when(player1.toString()).thenReturn("Player1");
    when(player2.toString()).thenReturn("Player2");
    when(player1.getScore()).thenReturn(0);
    when(player2.getScore()).thenReturn(0);

    // when
    game.play();

    // then
    verify(userInterface).display(eq("Welcome to the Rock-Paper-Scissors game!"));
    verify(player1).chooseWeapon(eq(game));
    verify(player2).chooseWeapon(eq(game));
    verify(player1).challenge(eq(player2));
    verify(userInterface, times(2)).display(eq("It's a draw!"));
    verify(userInterface).display(eq("*** Final Result ***"));
    verify(userInterface).display(eq("Player1 scored: 0, Player2 scored: 0"));
    verify(userInterface).display(eq("Thanks for playing. Goodbye!"));
  }

}
