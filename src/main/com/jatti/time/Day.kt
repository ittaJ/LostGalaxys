package com.jatti.time

/**
 * Days of week
 * Based on names from Burmese Calendar, French Republican Calendar, Egyptian Calendar and Greek Calendar
 * @author Jatti
 * @version 1.1
 */
enum class Day{

    IMIX, AJAW, MESHIR, MULUC, HATUR, NAYA, YAHWANI, ZEHTA;

    fun nextDay(): Day{
         if(this.name == ZEHTA.name){
             Year.days.put(Year.days.size+1, IMIX)
             return IMIX
        }
        Year.days.put(Year.days.size+1, Day.values()[this.ordinal+1])
        return Day.values()[this.ordinal+1]
    }
}