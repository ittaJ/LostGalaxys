package com.jatti.achievements

import com.jatti.achievements.prize.Prize

/**
 *  Represents Achievements
 *  @author Jatti
 *  @version 1.1
 *
 *  @param id Achievement's ID
 */
class Achievement(var id: Int) {

    var name: String = ""
    var desc: List<String> = ArrayList()
    var prize: Prize? = null
    var difficulty: AchievementDifficulty? = null

    companion object {
        /**
         * Creates new builder to make Achievement
         */
        @JvmStatic
        fun builder(id: Int): AchievementBuilder {
            return AchievementBuilder(id)
        }

    }

    /**
     * What will happen after getting Achievement
     * @param after what will happen after
     */
    fun afterGetting(after: () -> Unit){
        after()
    }

}

/**
 * Builder for achievements
 * @author Jatti
 * @version 1.0
 *
 * @param id Achievement's ID
 */
class AchievementBuilder(id: Int) {

    private val ach = Achievement(id)

    /**
     * Adds name to new Achievement
     * @param name Achievement's name
     */
    fun withName(name: String): AchievementBuilder {
        ach.name = name
        return this
    }

    /**
     * Adds description to new Achievement
     * @param desc Achievement's descriptions
     */
    fun withDesc(desc: List<String>): AchievementBuilder {
        ach.desc = desc
        return this
    }

    /**
     * Adds Prize to new Achievement
     * @param prize Achievement's prize
     */
    fun withPrize(prize: Prize): AchievementBuilder {
        ach.prize = prize
        return this
    }

    /**
     * Adds difficulty to new Achievement
     * @param difficulty Difficulty of achievement
     */
    fun withDifficulty(difficulty: AchievementDifficulty): AchievementBuilder {
        ach.difficulty = difficulty
        return this
    }

    /**
     * Creates new Achievement
     * @return Achievement
     */
    fun build(): Achievement {
        return ach
    }

}