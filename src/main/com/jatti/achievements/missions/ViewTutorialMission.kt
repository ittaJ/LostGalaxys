package com.jatti.achievements.missions

import com.jatti.achievements.Achievement
import com.jatti.achievements.AchievementDifficulty
import com.jatti.achievements.prize.Prize
import com.jatti.user.User
import org.bukkit.ChatColor
import java.util.*

/**
 * Mission to view tutorial
 * @author Jatti
 * @version 1.1
 */
class ViewTutorialMission : Mission {

    override val name: String = "Zobacz Samouczek"
    override val id: Int = 2
    override val lore: List<String> = Arrays.asList("Zobacz samouczek", "No zobacz noo")

    override fun onComplete(user: User) {

        if (user.missions!!.contains(id)) {
            user.sendMessage("" + ChatColor.GOLD + "[" + ChatColor.AQUA + "Misje" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Zakonczyles misje " + ChatColor.DARK_GREEN + "' " + name + "'" + ChatColor.GREEN + "!")

            user.addAchievement(Achievement.builder(2).withName("Samouczek")
                    .withDesc(Arrays.asList("Zobacz samouczek"))
                    .withDifficulty(AchievementDifficulty.EASY)
                    .withPrize(Prize.builder().forUser(user).withGold(100).withExp(100.0).build()).build())
        }
    }

    override fun onGet(user: User) {

        user.sendMessage("" + ChatColor.GOLD + "[" + ChatColor.AQUA + "Misje" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Dostales nowa misje!")
        user.sendMessage("" + ChatColor.GREEN + "Zobacz samouczek, by zdobyc osiagniecie, oraz pare nagrod!")
        user.addMission(id)

    }

}