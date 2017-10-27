package com.jatti.achievements.missions.npc

import com.jatti.achievements.missions.Mission
import com.jatti.user.User
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent

/**
 * Listener when player clicks NPC
 * @author Jatti
 * @version 1.2
 */
class NpcClick : Listener {

    companion object {
        /**
         * List of all missions that you can get from NPC
         * @return ArrayList<Mission>
         */
        @JvmStatic
        fun getMissions(): ArrayList<Mission> {
            return ArrayList()
        }

        /**
         * Method for adding mission to mission's list
         * @param mission mission to add
         */
        @JvmStatic
        fun addMission(mission:Mission){
            if(!getMissions().contains(mission)){
                getMissions().add(mission)
            }
        }
    }

    @EventHandler
    fun onClick(evt: PlayerInteractAtEntityEvent) {

        if (evt.rightClicked.type == EntityType.VILLAGER) {

            for (n in NpcUtils.getNpcs()) {

                if (n.entityId == evt.rightClicked.entityId) {

                    val u: User = User.get(evt.player.name)

                    for (mission in getMissions()) {

                        if (n.id == mission.id) {

                            if (u.missions!!.contains(mission.id)) {

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