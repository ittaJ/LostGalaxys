package com.jatti.achievements.missions.npc

import com.jatti.achievements.missions.Mission
import com.jatti.achievements.missions.MissionsList
import com.jatti.user.User
import com.jatti.user.ranks.MinimalRankCheck
import org.bukkit.ChatColor
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import kotlin.reflect.KClass
import kotlin.reflect.full.functions

/**
 * Listener when player clicks NPC
 * @author Jatti
 * @version 1.2
 */
class NpcClick : Listener {

    @EventHandler
    fun onClick(evt: PlayerInteractAtEntityEvent) {

        if (evt.rightClicked.type == EntityType.VILLAGER) {

            for (n in NpcUtils.getNpcs()) {

                if (n.entityId == evt.rightClicked.entityId) {

                    val u: User = User.get(evt.player.name)

                    for (mission in MissionsList.getAllNpcMissions()!!) {

                        if (n.id == mission.id) {

                            if (u.missions!!.contains(mission.id)) {

                                for(f in mission::class.functions) {

                                    if(f.name == "onComplete"){

                                        if(u.rank!!.name == MinimalRankCheck.check(f) || MinimalRankCheck.check(f) == null) {

                                            mission.onComplete(u)
                                        }else{
                                            u.sendMessage("${ChatColor.DARK_RED} Z twoja ranga nie mozesz zakonczyc tej misji!")
                                        }
                                    }


                                }

                            } else {

                                for( f in mission::class.functions) {

                                    if(f.name == "onGet") {

                                        if(u.rank!!.name == MinimalRankCheck.check(f) || MinimalRankCheck.check(f) == null) {

                                            mission.onGet(u)
                                        }else{
                                            u.sendMessage("${ChatColor.DARK_RED} Z twoja ranga nie mozesz zakonczyc tej misji!")
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