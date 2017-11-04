package com.jatti.entity

import com.jatti.user.User
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import java.util.*

/**
 * Class for entities
 * @author Jatti
 * @version 1.1
 *
 * @param type type of entity
 */
//TODO Rewrite
class Entity(var type: EntityType?) {

    constructor() : this(null)

    //TODO add pets
    var isTamed: Boolean = false
    var tamer: User? = null
    var isAgressive: Boolean = true
    var level: Int = 0
    var expToDrop: Double = 0.0
    var id: Int = 0
    var life: Int = 0
    var entityCategory: EntityCategory? = null


    init {
        EntitiesUtils.addEntity(this)
    }

    /**
     * Method that check if entity was hit by user or hit user
     *
     * @param hit if entity was hit
     * @param user user that was hit by entity or hit entity
     */
    fun onHit(hit: Boolean, user: User) {

        if (isAgressive) {

            return if (hit) {
                Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, user))
            } else {
                Bukkit.getPluginManager().callEvent(MEntityHitEvent(user, this))
            }

        } else {
            if (hit) {
                Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, user))
            }
        }

        if (isTamed) {
            if (hit) {
                if (user == tamer!!) {
                    user.sendMessage("${ChatColor.DARK_RED}Nie mozesz udezyc swojego zwierzaka!")
                } else {
                    Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, user))
                }
            }
        }

    }

    /**
     * Method when entity is creating
     * @param location location where entity is creating
     */
    fun onCreate(location: Location) {
        Bukkit.getPluginManager().callEvent(MEntityCreateEvent(this, location))
    }

    /**
     * Method when entity deaths
     * @param killer killer
     */
    fun onDeath(killer: User) {
        Bukkit.getPluginManager().callEvent(MEntityDeathEvent(this, killer))
    }

    /**
     * Method that shuffles entity's type, level, exp and life
     */
    fun shuffle() {

        type = EntitiesUtils.getRandType()
        //TODO add better leveling system
        level = Random().nextInt(10)
        expToDrop = Random().nextDouble() + level
        life = level * 5

    }


    companion object {

        /**
         * Gets entity from list with all entities
         * @param id entity's ID
         */
        @JvmStatic
        fun get(id: Int): Entity {

            EntitiesUtils.getEntities()
                    .filter { it.id == id }
                    .forEach { return it }

            return Entity(EntityType.RANDOM)

        }


    }
}
