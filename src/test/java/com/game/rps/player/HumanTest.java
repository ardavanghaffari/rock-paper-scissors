package com.game.rps.player;

import com.game.rps.Game;
import com.game.rps.TextBasedUserInterface;
import com.game.rps.weapon.Weapon;
import com.game.rps.weapon.WeaponFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HumanTest {

    @Mock
    private Game game;
    @Mock
    private WeaponFactory weaponFactory;
    @Mock
    private TextBasedUserInterface userInterface;
    @Mock
    private Weapon weapon;

    private Human human;

    @BeforeEach
    void setup() {
        when(game.getUserInterface()).thenReturn(userInterface);
        when(game.getWeaponFactory()).thenReturn(weaponFactory);
        when((weaponFactory.getAllWeapons())).thenReturn(List.of(weapon));
        when(weapon.toString()).thenReturn("weapon");
        when(weaponFactory.create(Mockito.anyInt())).thenReturn(weapon);

        human = new Human();
    }

    @Test
    void testChooseWeapon() {
        when(userInterface.readUserInput()).thenReturn("1");

        human.chooseWeapon(game);

        verify(userInterface).display(eq("Choose your weapon:"));
        verify(userInterface).display(eq("1- weapon"));
        verify(userInterface).display(eq("Your choice: "), eq(false));
        verify(weaponFactory).create(eq(0));
        verify(userInterface).display(eq("You chose: weapon"));
        assertEquals(weapon, human.getWeapon());
    }

    @Test
    void testNumberOutOfRange() {
        when(userInterface.readUserInput()).thenReturn("2", "1");

        human.chooseWeapon(game);

        verify(userInterface).display(eq("Enter a number between 1 and 1"));
        verify(userInterface).display(eq("You chose: weapon"));
        verify(userInterface, times(2)).readUserInput();
        assertEquals(weapon, human.getWeapon());
    }

    @Test
    void testInputNotNumber() {
        when(userInterface.readUserInput()).thenReturn("a", "1");

        human.chooseWeapon(game);

        verify(userInterface).display(eq("Invalid input, Enter a number!"));
        verify(userInterface).display(eq("You chose: weapon"));
        verify(userInterface, times(2)).readUserInput();
        assertEquals(weapon, human.getWeapon());
    }

}
