package com.jatti.time

/**
 * Months of year
 * Based on names from Burmese Calendar, French Republican Calendar, Egyptian Calendar and Greek Calendar
 * @author Jatti
 * @version 1.1
 */
enum class Month(val weeksAmount: Int, var weeks: ArrayList<Week>) {

    THERMIDOR(3, ArrayList()), PRAIRIAL(5, ArrayList()), BRUMAIRE(4, ArrayList()), CAROTTE(2, ArrayList()), MIEL(3, ArrayList()), ENDIVE(5, ArrayList());

    /**
     * Changes week to next one
     */
    fun nextWeek(){
        if(weeks.size+1 > weeksAmount){
            if(this.name != ENDIVE.name) {
                nextMonth()
            }else{
                Year.nextYear()
            }
        }else{
            val w = Week.builder().forMonth(this).freeBuild()
            Year.weeks.add(w)
            weeks.add(w)
        }
    }

    /**
     * Changes month to next one
     */
    fun nextMonth(){
        if(weeks.size+1 > weeksAmount){
            if(name != ENDIVE.name){
                Year.weeks.add(Week.builder().forMonth(Month.values()[this.ordinal+1]).build())
            }else{
                Year.nextYear()
            }
        }
    }
}