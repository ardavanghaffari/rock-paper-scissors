package com.game.prs.player;

import com.game.prs.PrsGame;
import com.game.prs.TextBasedUserInterface;
import com.game.prs.weapon.Weapon;
import com.game.prs.weapon.WeaponFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComputerTest {
  @Mock
  PrsGame game;
  @Mock
  WeaponFactory weaponFactory;
  @Mock
  TextBasedUserInterface userInterface;
  @Mock
  Weapon weapon;

  @Test
  public void testChooseWeapon() {
    when(game.getUserInterface()).thenReturn(userInterface);
    when(game.getWeaponFactory()).thenReturn(weaponFactory);
    when(weapon.toString()).thenReturn("weapon");
    when(weaponFactory.create()).thenReturn(weapon);

    Computer computer = new Computer();
    computer.chooseWeapon(game);

    Assertions.assertEquals(weapon, computer.getWeapon());
    verify(userInterface).display(eq("The computer chose: weapon"));
  }
}
