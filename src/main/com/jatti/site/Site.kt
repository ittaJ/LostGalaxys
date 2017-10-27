package com.jatti.site

/**
 * Annotation for checking if method or class is only usable on Sponge or Spigot
 * @author Jatti
 * @version 1.0
 *
 * @param sitetype Sponge or Spigot
 * @param canBeUsedOnOther if e.g method for Sponge can be used by Spigot
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class Site(val sitetype: SiteType, val canBeUsedOnOther: Boolean)