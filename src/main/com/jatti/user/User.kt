package com.jatti.user

import com.jatti.achievements.Achievement
import com.jatti.user.rangs.Rank
import com.jatti.user.tutorial.TutorialEvent
import net.minecraft.server.v1_12_R1.IChatBaseComponent
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import java.util.ArrayList

open class User(var name:String){

    var gold:Int = 0
    var hasComputer:Boolean = false
    var level:Int = 0
    var exp:Double = 0.0
    var rank: Rank? = null
    var achievements: MutableList<Achievement>? = ArrayList()
    var missions: MutableList<Int>? = ArrayList()

    init{
        UserUtils.addUser(this)
    }

    companion object {

        @JvmStatic
        fun get(name:String):User{

            for(u in UserUtils.getUsers()){

                if(u.name == name){
                    return u
                }

            }

            return User(name)

        }

    }

    fun getPlayer():Player{
        return Bukkit.getPlayer(name)
    }

    fun sendActionBar(fadein:Int, stay:Int, fadeout:Int, message:String){
        val ic = IChatBaseComponent.ChatSerializer.a("{\"text\": \"$message\"}")
        val pc = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, ic, fadein, stay, fadeout)
        (getPlayer() as CraftPlayer).handle.playerConnection.sendPacket(pc)
    }

    fun checkIfNextLevel(){
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

    fun addLevels(levels:Int){
        Bukkit.getPluginManager().callEvent(LevelUpEvent(this, level, level + levels))
        this.level = level + levels
    }

    fun addExp(exp: Double) {
        this.exp = this.exp + exp
        checkIfNextLevel()
    }

    fun sendMessage(message: String){
        getPlayer().sendMessage(message)
    }

    fun addAchievement(achievement: Achievement) {
        if (!achievements!!.contains(achievement)) achievements!!.add(achievement)
        sendMessage("" + ChatColor.GREEN + "Zdobyto osiagniecie " + achievement.name + " !")
    }

    fun addGold(gold: Int) {
        this.gold = this.gold + gold
    }

    fun showTutorial() {
        Bukkit.getPluginManager().callEvent(TutorialEvent(this))
    }

    fun addMission(id: Int?) {
        if (!missions!!.contains(id)) missions!!.add(id!!)
    }

}