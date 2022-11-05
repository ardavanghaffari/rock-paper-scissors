package com.game.prs;

import com.game.prs.player.Player;
import com.game.prs.weapon.WeaponFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrsGameTest {
  @Mock
  Player player1;
  @Mock
  Player player2;
  @Mock
  WeaponFactory weaponFactory;
  @Mock
  TextBasedUserInterface userInterface;

  @Test
  public void testPlayWithPlayer1Winner() {
    when(player1.challenge(player2)).thenReturn(1);
    when(player1.toString()).thenReturn("Player1");
    when(player2.toString()).thenReturn("Player2");
    when(player1.getScore()).thenReturn(1);
    when(player2.getScore()).thenReturn(0);

    PrsGame prsGame = new PrsGame(player1, player2, weaponFactory, userInterface, 1);
    prsGame.play();

    verify(userInterface).display(eq("Welcome to the Paper-Rock-Scissors game!"));
    verify(player1).chooseWeapon(eq(prsGame));
    verify(player2).chooseWeapon(eq(prsGame));
    verify(player1).challenge(eq(player2));
    verify(userInterface).display(eq("Player1 won this round!"));
    verify(userInterface).display(eq("*** Final Result ***"));
    verify(userInterface).display(eq("Player1 won the game!"));
    verify(userInterface).display(eq("Player1 scored: 1, Player2 scored: 0"));
    verify(userInterface).display(eq("Thanks for playing. Goodbye!"));
  }

  @Test
  public void testPlayWithPlayer2Winner() {
    when(player1.challenge(player2)).thenReturn(-1);
    when(player1.toString()).thenReturn("Player1");
    when(player2.toString()).thenReturn("Player2");
    when(player1.getScore()).thenReturn(0);
    when(player2.getScore()).thenReturn(1);

    PrsGame prsGame = new PrsGame(player1, player2, weaponFactory, userInterface, 1);
    prsGame.play();

    verify(userInterface).display(eq("Welcome to the Paper-Rock-Scissors game!"));
    verify(player1).chooseWeapon(eq(prsGame));
    verify(player2).chooseWeapon(eq(prsGame));
    verify(player1).challenge(eq(player2));
    verify(userInterface).display(eq("Player2 won this round!"));
    verify(userInterface).display(eq("*** Final Result ***"));
    verify(userInterface).display(eq("Player2 won the game!"));
    verify(userInterface).display(eq("Player1 scored: 0, Player2 scored: 1"));
    verify(userInterface).display(eq("Thanks for playing. Goodbye!"));
  }

  @Test
  public void testPlayDraw() {
    when(player1.challenge(player2)).thenReturn(0);
    when(player1.toString()).thenReturn("Player1");
    when(player2.toString()).thenReturn("Player2");
    when(player1.getScore()).thenReturn(0);
    when(player2.getScore()).thenReturn(0);

    PrsGame prsGame = new PrsGame(player1, player2, weaponFactory, userInterface, 1);
    prsGame.play();

    verify(userInterface).display(eq("Welcome to the Paper-Rock-Scissors game!"));
    verify(player1).chooseWeapon(eq(prsGame));
    verify(player2).chooseWeapon(eq(prsGame));
    verify(player1).challenge(eq(player2));
    verify(userInterface, times(2)).display(eq("It's a draw!"));
    verify(userInterface).display(eq("*** Final Result ***"));
    verify(userInterface).display(eq("Player1 scored: 0, Player2 scored: 0"));
    verify(userInterface).display(eq("Thanks for playing. Goodbye!"));
  }
}
