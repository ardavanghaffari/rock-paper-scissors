package com.game.rps.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WeaponFactoryTest {

  private final WeaponFactory weaponFactory = new WeaponFactory(Paper::new, Rock::new, Scissor::new);

  @Test
  void testCreateWeapon() {
    assertTrue(weaponFactory.create(1) instanceof Rock);
    assertTrue(weaponFactory.create(0) instanceof Paper);
    assertTrue(weaponFactory.create(2) instanceof Scissor);
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
