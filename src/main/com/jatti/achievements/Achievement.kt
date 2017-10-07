package com.jatti.achievements

import com.jatti.achievements.prize.Prize

open class Achievement(var id: Int) {

    var name: String = ""
    var desc: List<String> = ArrayList()
    var prize: Prize? = null
    var difficulty: AchievementDifficulty? = null

    companion object {

        fun builder(id: Int): AchievementBuilder{
            return AchievementBuilder(id)
        }

    }

}

class AchievementBuilder(id: Int) {

    private val ach = Achievement(id)

    fun withName(name: String): AchievementBuilder {
        ach.name = name
        return this
    }

    fun withDesc(desc: List<String>): AchievementBuilder {
        ach.desc = desc
        return this
    }

    fun withPrize(prize: Prize): AchievementBuilder {
        ach.prize = prize
        return this
    }

    fun withDifficulty(difficulty: AchievementDifficulty): AchievementBuilder {
        ach.difficulty = difficulty
        return this
    }

    fun build(): Achievement {
        return ach
    }

}