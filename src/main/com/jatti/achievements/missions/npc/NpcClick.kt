package com.jatti.achievements.missions.npc

import com.jatti.achievements.missions.MissionsList
import com.jatti.achievements.missions.npc.NpcClickCheckerType.DIMENSION
import com.jatti.achievements.missions.npc.NpcClickCheckerType.RANK
import com.jatti.gates.dimension.InDimensionChecker
import com.jatti.user.User
import com.jatti.user.ranks.SpecifiedRankCheck
import org.bukkit.ChatColor
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import kotlin.reflect.full.functions

/**
 * Listener when player clicks NPC
 * @author Jatti
 * @version 1.3
 */

class NpcClick : Listener {

    @EventHandler
    fun onClick(evt: PlayerInteractAtEntityEvent) {

        if (evt.rightClicked.type == EntityType.VILLAGER) {

            for (n in NpcUtils.getNpcs()) {

                if (n.entityId == evt.rightClicked.entityId) {

                    val u: User = User.get(evt.player.name)

                    NpcClickChecker.check(u, n, RANK)
                    NpcClickChecker.check(u, n, DIMENSION)

                }

            }

        }
    }
}

/**
 * Class for checking functions while player clicks npc
 * @author Jatti
 * @version 1.0
 */
class NpcClickChecker {
    //TODO Rewrite
    companion object {
        @JvmStatic
        fun check(user: User, npc: Npc, type: NpcClickCheckerType) {

            for (mission in MissionsList.getAllNpcMissions()!!) {

                if (npc.id == mission.id) {

                    if (user.missions!!.contains(mission.id)) {

                        for (f in mission::class.functions) {

                            if (f.name == "onGet") {

                                when (type) {

                                    NpcClickCheckerType.RANK ->

                                        if (SpecifiedRankCheck.check(f) == user.rank!!.name || SpecifiedRankCheck.check(f) == null) {

                                            mission.onGet(user)

                                        } else {

                                            user.sendMessage("${ChatColor.DARK_RED} Z ta ranga nie mozesz zdobyc tej misji!")

                                        }

                                    NpcClickCheckerType.DIMENSION ->
                                        println("You can't make mission gettable only in specified dimension!")
                                }

                                if (f.name == "onComplete") {

                                    when (type) {

                                        NpcClickCheckerType.DIMENSION ->

                                            if (InDimensionChecker.check(f) == user.dimension!!.name || InDimensionChecker.check(f) == null) {

                                                mission.onComplete(user)

                                            } else {

                                                user.sendMessage("${ChatColor.DARK_RED} W tym swiecie nie mozesz zakonczyc tej misji!")

                                            }

                                        NpcClickCheckerType.RANK ->

                                            if (SpecifiedRankCheck.check(f) == user.rank!!.name || SpecifiedRankCheck.check(f) == null) {

                                                mission.onComplete(user)

                                            } else {

                                                user.sendMessage("${ChatColor.DARK_RED} Z ta ranga nie mozesz zakonczyc misji!")

                                            }
                                    }

                                }

                            }

                        }

                    }

                }

            }
        }
    }

}

/**
 * Types of checking for NpcClickChecker
 * @author Jatti
 * @version 1.0
 */
enum class NpcClickCheckerType {

    DIMENSION, RANK;

}