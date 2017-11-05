package com.jatti.achievements.missions

import kotlin.reflect.KClass

/**
 * Annotation that marks mission as daily, if mission is daily after 24houres (igt) it will disappear from player's missions
 * @author Jatti
 * @version 1.0
 *
 * @param isDaily if mission is daily
 */
@Target(AnnotationTarget.CLASS)
annotation class IsDaily(val isDaily: Boolean)


/**
 * Class for checking if mission is daily
 * @author Jatti
 * @version 1.0
 */
class IsDailyChecker{

    companion object {

        /**
         * Function for checking if mission is daily
         * @param kc class to check
         */
        @JvmStatic
        fun check(kc: KClass<*>): Boolean?{

            if(kc.annotations.isNotEmpty()){

                for(ann in kc.annotations){

                    if(ann == IsDaily::class){

                        ann as IsDaily

                        return ann.isDaily

                    }

                }

            }

            return null
        }
    }

}