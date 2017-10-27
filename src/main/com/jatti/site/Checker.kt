package com.jatti.site

import kotlin.reflect.KClass
import kotlin.reflect.full.functions

/**
 * Checker that checks if class has methods which can be only used on Spigot or Sponge
 *
 * @author Jatti
 * @version 1.0
 */
class Checker{

    companion object {

        @JvmStatic
        fun check(kClass: KClass<*>, siteType: SiteType): Boolean{

            for(f in kClass.functions){

                if(f.annotations.isNotEmpty()){

                    for(ann in f.annotations){

                        if(ann.annotationClass == Site::class){

                            val site = ann as Site

                            return site.sitetype == siteType || site.canBeUsedOnOther

                        }

                    }

                }

            }
            return false
        }
    }

}