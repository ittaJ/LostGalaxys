package com.jatti.entity

/**
 * Types of entity
 * @author Jatti
 * @version 1.0
 *
 * @param namee type's name
 * @param type type from Bukkit
 * @see org.bukkit.entity.EntityType
 */
enum class EntityType(val namee: String, val type: org.bukkit.entity.EntityType) {

    //TODO Add more types
    RANDOM(),
    ZOMBIE("Zombie", org.bukkit.entity.EntityType.ZOMBIE),
    DESERT_ZOMBIE("Pustynny Zombie", org.bukkit.entity.EntityType.HUSK),
    WISP("Czastka Energii", org.bukkit.entity.EntityType.BAT),
    SUCKER("Pijawka", org.bukkit.entity.EntityType.SLIME),
    DOG("Pies", org.bukkit.entity.EntityType.WOLF);

    /**
     * Empty constructor for random type or for not working types
     */
    constructor()

}