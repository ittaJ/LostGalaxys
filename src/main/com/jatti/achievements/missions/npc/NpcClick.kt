package com.jatti.achievements.missions.npc

import com.jatti.achievements.missions.Mission
import com.jatti.achievements.missions.TestMission
import com.jatti.user.User
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent

class NpcClick: Listener {

    @EventHandler
    fun onClick(evt: PlayerInteractAtEntityEvent) {

        if (evt.rightClicked.type == EntityType.VILLAGER) {

            for (n in NpcUtils.getNpcs()) {

                if (n.location == evt.rightClicked.location) {

                    val u: User = User.get(evt.player.name)
                    val missions: ArrayList<Mission> = ArrayList()
                    missions.add(TestMission())

                    for (mission in missions) {

                        if (n.id == mission.id) {

                            if (u.missionsID.contains(mission.id)) {

                                mission.onComplete(u)

                            } else {

                                mission.onGet(u)

                            }

                        }

                    }

                }

            }

        }
    }
}