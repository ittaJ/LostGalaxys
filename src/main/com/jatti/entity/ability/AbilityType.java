package com.jatti.entity.ability;

public enum AbilityType {


    FIRE(10), LIGHT(30), DARK(2), EARTH(50), AIR(25), WATER(40), THUNDER(17);

    int chance;

    AbilityType(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

}
