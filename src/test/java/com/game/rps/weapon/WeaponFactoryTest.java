package com.game.rps.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WeaponFactoryTest {

    private final WeaponFactory weaponFactory = new WeaponFactory(Paper::new, Rock::new, Scissor::new);

    @Test
    void testCreateWeapon() {
        assertInstanceOf(Rock.class, weaponFactory.create(1));
        assertInstanceOf(Paper.class, weaponFactory.create(0));
        assertInstanceOf(Scissor.class, weaponFactory.create(2));
    }

    @Test
    void testCreateRandomWeapon() {
        assertNotNull(weaponFactory.create());
    }

    @Test
    void testGetAllWeapons() {
        assertEquals(3, weaponFactory.getAllWeapons().size());
        assertTrue(weaponFactory.getAllWeapons().stream().anyMatch(weapon -> weapon instanceof Rock));
        assertTrue(weaponFactory.getAllWeapons().stream().anyMatch(weapon -> weapon instanceof Paper));
        assertTrue(weaponFactory.getAllWeapons().stream().anyMatch(weapon -> weapon instanceof Scissor));
    }

}
