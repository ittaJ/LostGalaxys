package com.jatti.achievements.missions

import com.jatti.user.User
import org.bukkit.ChatColor

class TestMission:Mission{

    override val name: String = "Pierwsza"
    override val value: Int = 1

    override fun onComplete(user:User) {

        user.sendMessage(""+ChatColor.GOLD+"Brawo skonczyles testowa misje!")
        user.level++
    }

    override fun onGet(user:User) {

        user.sendMessage(""+ChatColor.GOLD+"Dostales nowa misje!")

    }
}