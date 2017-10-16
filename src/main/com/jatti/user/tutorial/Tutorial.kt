package com.jatti.user.tutorial

import com.jatti.achievements.missions.ViewTutorialMission
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

/**
 * Listener when player is watching tutorial
 * @author Jatti
 * @version 1.0
 *
 */
class Tutorial : Listener {

    @EventHandler
    fun onTutorial(evt: TutorialEvent) {

        //TODO make tutorial
        ViewTutorialMission().onComplete(evt.user)
    }

}