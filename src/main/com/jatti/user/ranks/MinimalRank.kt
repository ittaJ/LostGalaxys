package com.jatti.user.ranks

import kotlin.reflect.KFunction
/**
 * Annotation for methods/functions which makes them only for users with specified rank
 * @author Jatti
 * @version 1.0
 *
 * @param rankName rank's name
 */
@Target(AnnotationTarget.FUNCTION)
annotation class MinimalRank(val rankName:String)


/**
 * Class for checking if method has @MinimalRank annotation
 * @author Jatti
 * @version 1.0
 *
 */
class MinimalRankCheck{

    companion object {
        /**
         * Method that checks function if has @MinimalRank annotation
         *
         * @param function function to check
         * @return String?
         */
        @JvmStatic
        fun check(function:KFunction<*>):String?{

            if(function.annotations.isNotEmpty()){

                for(ann in function.annotations){

                    if(ann.annotationClass == MinimalRank::class){

                        val minimalRank = ann as MinimalRank

                        return minimalRank.rankName

                    }

                }

            }

            return null

        }
    }

}