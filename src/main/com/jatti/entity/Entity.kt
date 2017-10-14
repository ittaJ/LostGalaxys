package com.jatti.entity

import com.jatti.user.User
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import java.util.*

open class Entity(open var type: EntityType?) {

    constructor() : this(null)
    //TODO add pets
    open var isTamed:Boolean = false
    open var tamer:User? = null
    open var isAgressive:Boolean = true
    open var level: Int = 0
    open var expToDrop: Double = 0.0
    open var id: Int = 0
    open var life: Int = 0
    open var entityCategory:EntityCategory? = null

    fun onHit(hitted: Boolean, user: User) {

        if(isAgressive){

            return if(hitted){
                Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, user))
            }else{
                Bukkit.getPluginManager().callEvent(MEntityHitEvent(user, this))
            }

        }else{
            if(hitted){
                Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, user))
            }
        }

        if(isTamed){
            if(hitted){
                if(user == tamer!!){
                    user.sendMessage("" + ChatColor.DARK_RED + "Nie mozesz udezyc swojego zwierzaka!")
                }else{
                    Bukkit.getPluginManager().callEvent(MEntityHittedEvent(this, user))
                }
            }
        }

    }

    fun onCreate(location: Location) {
        Bukkit.getPluginManager().callEvent(MEntityCreateEvent(this, location))
    }

    fun onDeath(killer: User) {
        Bukkit.getPluginManager().callEvent(MEntityDeathEvent(this, killer))
    }

    fun shuffle() {

        type = EntitiesUtils.getRandType()
        //TODO add better leveling system
        level = Random().nextInt(10)
        expToDrop = Random().nextDouble() + level
        life = level * 5

    }

    init {
        EntitiesUtils.addEntity(this)
    }

    companion object {

        @JvmStatic
        fun get(id: Int): Entity {

            EntitiesUtils.getEntities()
                    .filter { it.id == id }
                    .forEach { return it }

            return Entity(EntityType.RANDOM)

        }


    }
}
