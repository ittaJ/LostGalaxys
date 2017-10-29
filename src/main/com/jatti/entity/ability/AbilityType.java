package com.jatti.entity.ability;

/**
 * Types of abilities for mobs
 *
 * @author Jatti
 * @version 1.0
 */
public enum AbilityType {

    FIRE(10), LIGHT(30), DARK(2), EARTH(50), AIR(25), WATER(40), THUNDER(17);

    int chance;

    /**
     * type of ability with chance
     * @param chance chance for mob to get this ability
     */
    AbilityType(int chance) {
        this.chance = chance;
    }

    /**
     * Gets chance to get this ability
     * @return int
     */
    public int getChance() {
        return chance;
    }

}
