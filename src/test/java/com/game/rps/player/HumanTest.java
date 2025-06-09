package com.game.rps.player;

import com.game.rps.Game;
import com.game.rps.TextBasedUserInterface;
import com.game.rps.weapon.Weapon;
import com.game.rps.weapon.WeaponFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HumanTest {
  @Mock
  Game game;
  @Mock
  WeaponFactory weaponFactory;
  @Mock
  TextBasedUserInterface userInterface;
  @Mock
  Weapon weapon;

  @BeforeEach
  public void setup() {
    when(game.getUserInterface()).thenReturn(userInterface);
    when(game.getWeaponFactory()).thenReturn(weaponFactory);
    when((weaponFactory.getAllWeapons())).thenReturn(List.of(weapon));
    when(weapon.toString()).thenReturn("weapon");
    when(weaponFactory.create(Mockito.anyInt())).thenReturn(weapon);
  }

  @Test
  public void testChooseWeapon() {
    when(userInterface.readUserInput()).thenReturn("1");

    Human human = new Human();
    human.chooseWeapon(game);

    verify(userInterface).display(eq("Choose your weapon:"));
    verify(userInterface).display(eq("1- weapon"));
    verify(userInterface).display(eq("Your choice: "), eq(false));
    verify(weaponFactory).create(eq(0));
    verify(userInterface).display(eq("You chose: weapon"));
    Assertions.assertEquals(weapon, human.getWeapon());
  }

  @Test
  public void testNumberOutOfRange() {
    when(userInterface.readUserInput()).thenReturn("2", "1");

    Human human = new Human();
    human.chooseWeapon(game);

    verify(userInterface).display(eq("Enter a number between 1 and 1"));
    verify(userInterface).display(eq("You chose: weapon"));
    verify(userInterface, times(2)).readUserInput();
    Assertions.assertEquals(weapon, human.getWeapon());
  }

  @Test
  public void testInputNotNumber() {
    when(userInterface.readUserInput()).thenReturn("a", "1");

    Human human = new Human();
    human.chooseWeapon(game);

    verify(userInterface).display(eq("Invalid input, Enter a number!"));
    verify(userInterface).display(eq("You chose: weapon"));
    verify(userInterface, times(2)).readUserInput();
    Assertions.assertEquals(weapon, human.getWeapon());
  }
}
