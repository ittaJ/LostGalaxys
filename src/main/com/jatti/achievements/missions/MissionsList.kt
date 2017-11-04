package com.jatti.achievements.missions

class MissionsList {

    companion object {

        private var am = ArrayList<Mission>()
        private var amn = ArrayList<Mission>()

        @JvmStatic
        fun getAllMissions(): ArrayList<Mission>? {
            return am
        }


        @JvmStatic
        fun getAllNpcMissions(): ArrayList<Mission>? {
            return amn
        }

        @JvmStatic
        fun addMission(mission: Mission, type: AddType) {

            when (type) {

                AddType.ALL -> getAllMissions()!!.add(mission)
                AddType.NPC -> getAllNpcMissions()!!.add(mission)
            }

        }
    }

}

enum class AddType {

    ALL, NPC

}