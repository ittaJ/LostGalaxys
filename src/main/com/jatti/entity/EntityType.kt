package com.jatti.entity


enum class EntityType(val namee:String, val type: org.bukkit.entity.EntityType) {

    //TODO Add more types
    RANDOM(),
    ZOMBIE("Zombie", org.bukkit.entity.EntityType.ZOMBIE),
    DESERT_ZOMBIE("Pustynny Zombie", org.bukkit.entity.EntityType.HUSK),
    WISP(),
    SUCKER("Pijawka", org.bukkit.entity.EntityType.SLIME);

    constructor()
}