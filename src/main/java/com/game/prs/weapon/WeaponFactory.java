package com.game.prs.weapon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class WeaponFactory {
  private Random rand = new Random();
  private final Supplier<Weapon>[] suppliers;

  public WeaponFactory(Supplier<Weapon>... suppliers) {
    this.suppliers = suppliers;
  }

  public Weapon create() {
    return suppliers[rand.nextInt(suppliers.length)].get();
  }

  public Weapon create(int i) {
    return suppliers[i].get();
  }

  public List<Weapon> getAllWeapons() {
    return Arrays.stream(suppliers).map(Supplier::get).toList();
  }
}
