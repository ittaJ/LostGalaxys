package com.jatti.user.ranks

import kotlin.reflect.KFunction

/**
 * Annotation for Missions which makes them only for users with specified rank
 * @see com.jatti.user.ranks
 * @author Jatti
 * @version 1.0
 *
 * @param rankName rank's name
 */
@Target(AnnotationTarget.FUNCTION)
annotation class SpecifiedRank(val rankName: String)


/**
 * Class for checking if method has @SpecifiedRank annotation
 * @author Jatti
 * @version 1.1
 *
 */
object SpecifiedRankCheck {

    /**
     * Method that checks if function has @SpecifiedRank annotation
     *
     * @param function function to check
     * @return String?
     */
    @JvmStatic
    fun check(function: KFunction<*>): String? {

        if (function.annotations.isNotEmpty()) {

            tailrec fun check(int: Int): Int
                = if(function.annotations[int].annotationClass == SpecifiedRank::class) int else check(int+1)

            return(function.annotations[check(0)] as SpecifiedRank).rankName

        }

        return null

    }
}