package com.jatti.user

import com.jatti.achievements.Achievement
import com.jatti.gates.dimension.DimensionType
import com.jatti.user.ranks.Rank
import com.jatti.user.tutorial.TutorialEvent
import net.minecraft.server.v1_12_R1.IChatBaseComponent
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import java.util.*

/**
 * Represents player as user
 * @author Jatti
 * @version 1.0
 *
 * @param name user's name
 * */


//TODO Rewrite
class User(var name: String) {

    var gold: Int = 0
    var hasComputer: Boolean = false
    var level: Int = 0
    var exp: Double = 0.0
    var rank: Rank? = null
    var achievements: MutableList<Achievement>? = ArrayList()
    var missions: MutableList<Int>? = ArrayList()
    var dimension: DimensionType? = null

    init {
        UserUtils.addUser(this)
    }

    companion object {

        /**
         * Gets user with name from user's list, or creates new one
         * @param name user's name
         *
         * */
        @JvmStatic
        fun get(name: String): User {

            for (u in UserUtils.getUsers()) {

                if (u.name == name) {
                    return u
                }

            }

            return User(name)

        }

    }

    /**
     * Gets player from user
     * @return Player
     *
     */

    fun getPlayer(): Player {
        return Bukkit.getPlayer(name)
    }


    /**
     * Sends ActionBar for user
     * @param fadein time in which ActionBar will appear
     * @param stay how long ActionBar will stay
     * @param fadeout time in which ActionBar will disppear
     * @param message message will be shown as ActionBar
     *
     */
    fun sendActionBar(fadein: Int, stay: Int, fadeout: Int, message: String) {
        val ic = IChatBaseComponent.ChatSerializer.a("{\"text\": \"$message\"}")
        val pc = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, ic, fadein, stay, fadeout)
        (getPlayer() as CraftPlayer).handle.playerConnection.sendPacket(pc)
    }

    /**
     * Checks if User has enought exp to get next level, if yes automatically changes that level
     */
    fun checkIfNextLevel() {
        if (exp == 0.0) level = 0
        if (exp == (2 * (level + 1 + 4)).toDouble() && level < 8) {
            Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + 1))
            level += 1
        }
        if (exp == 2.5 * (level + 1 + 5) && level < 18 && level > 8) {
            Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + 1))
            level += 1
        }
        if (exp == (3 * (level + 1) + 20).toDouble() && level < 37 && level > 18) {
            Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + 1))
            level += 1
        }
        if (exp == (5 * (level + 1) + 3).toDouble() && level < 41 && level > 37) {
            Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + 1))
            level += 1
        }
        if (exp == (2 * (6 * ((level + 1) * 2))).toDouble() && level > 40) {
            Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + 1))
            level += 1
        }
    }

    /**
     * Adds specified amount of levels
     * @param levels amount of levels
     *
     */
    fun addLevels(levels: Int) {
        Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + levels))
        this.level = level + levels
    }

    /**
     * Add specified amount of exp and then checks if player has enought exp for next level
     * @param exp amount of exp
     *
     */
    fun addExp(exp: Double) {
        this.exp = this.exp + exp
        checkIfNextLevel()
    }

    /**
     * Sends message to player
     * @param message message which will be sended to player
     *
     */
    fun sendMessage(message: String) {
        getPlayer().sendMessage(message)
    }

    /**
     * Adds achievement to player's achievements if player doesn't have it
     * @param achievement achievement which will be added
     *
     */
    fun addAchievement(achievement: Achievement) {
        if (!achievements!!.contains(achievement)) achievements!!.add(achievement)
        sendMessage("${ChatColor.GREEN} /Zdobyto osiagniecie ${achievement.name} !")
    }

    /**
     * Adds specified amount of gold
     * @param gold amount of gold
     *
     */
    fun addGold(gold: Int) {
        this.gold = this.gold + gold
    }

    /**
     * Calls TutoiralEvent and shows tutorial
     */
    fun showTutorial() {
        Bukkit.getPluginManager().callEvent(TutorialEvent(this))
    }

    /**
     * Adds mission to player's missions if player doesn't have it
     * @param id mission's ID
     *
     */

    fun addMission(id: Int) {
        if (!missions!!.contains(id)) missions!!.add(id)
    }

}