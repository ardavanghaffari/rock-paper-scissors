package com.game.rps.player;

import com.game.rps.Game;
import com.game.rps.TextBasedUserInterface;
import com.game.rps.weapon.Weapon;
import com.game.rps.weapon.WeaponFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComputerTest {

  @Mock
  private Game game;
  @Mock
  private WeaponFactory weaponFactory;
  @Mock
  private TextBasedUserInterface userInterface;
  @Mock
  private Weapon weapon;

  private Computer computer = new Computer();

  @Test
  public void testChooseWeapon() {
    when(game.getUserInterface()).thenReturn(userInterface);
    when(game.getWeaponFactory()).thenReturn(weaponFactory);
    when(weapon.toString()).thenReturn("weapon");
    when(weaponFactory.create()).thenReturn(weapon);

    computer.chooseWeapon(game);

    assertEquals(weapon, computer.getWeapon());
    verify(userInterface).display(eq("The computer chose: weapon"));
  }

}
