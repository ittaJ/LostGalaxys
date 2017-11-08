package com.jatti.time

/**
 * Months of year
 * Based on names from Burmese Calendar, French Republican Calendar, Egyptian Calendar and Greek Calendar
 * @author Jatti
 * @version 1.0
 */
enum class Month(val weeksAmount: Int, var weeks: ArrayList<Week>) {

    THERMIDOR(3, ArrayList()), PRAIRIAL(5, ArrayList()), BRUMAIRE(4, ArrayList()), CAROTTE(2, ArrayList()), MIEL(3, ArrayList()), ENDIVE(5, ArrayList());

}