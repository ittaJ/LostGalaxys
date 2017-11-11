package com.jatti.gates.dimension

import kotlin.reflect.KFunction

/**
 * Annotation for Missions that allows player to complete mission only in specified dimension
 * @see com.jatti.achievements.missions
 * @see com.jatti.gates.dimension
 * @author Jatti
 * @version 1.0
 *
 * @param dimension
 */
@Target(AnnotationTarget.FUNCTION)
annotation class InDimension(val dimension: DimensionType)


/**
 * Class for checking if method has @InDimension annotation
 * @author Jatti
 * @version 1.1
 */
object InDimensionChecker {

    /**
     * Method that checks if function has @InDimension annotation
     *
     * @param function function to check
     * @return String?
     */

    @JvmStatic
    fun check(function: KFunction<*>): String? {

        if (function.annotations.isNotEmpty()) {

            tailrec fun check(int: Int): Int
            = if(function.annotations[int].annotationClass == InDimension::class) int else check(int+1)

            return (function.annotations[check(0)] as InDimension).dimension.name

        }
        return null
    }

}