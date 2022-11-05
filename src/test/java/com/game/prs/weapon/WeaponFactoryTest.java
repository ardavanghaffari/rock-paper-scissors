package com.game.prs.weapon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponFactoryTest {
  WeaponFactory weaponFactory = new WeaponFactory(Paper::new, Rock::new, Scissor::new);

  @Test
  public void testCreateWeapon() {
    assertTrue(weaponFactory.create(0) instanceof Paper);
    assertTrue(weaponFactory.create(1) instanceof Rock);
    assertTrue(weaponFactory.create(2) instanceof Scissor);
  }

  @Test
  public void testCreateRandomWeapon() {
    assertNotNull(weaponFactory.create());
  }

  @Test
  public void testGetAllWeapons() {
    assertEquals(3, weaponFactory.getAllWeapons().size());
    assertTrue(weaponFactory.getAllWeapons().stream().anyMatch(weapon -> weapon instanceof Paper));
    assertTrue(weaponFactory.getAllWeapons().stream().anyMatch(weapon -> weapon instanceof Rock));
    assertTrue(weaponFactory.getAllWeapons().stream().anyMatch(weapon -> weapon instanceof Scissor));
  }
}
