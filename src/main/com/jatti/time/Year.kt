package com.jatti.time

/**
 * Class for Years
 * @author Jatti
 * @version 1.0
 */
object Year{

    var which:Int = 0
    val weeks:ArrayList<Week> = ArrayList()
    val days:HashMap<Int, Day> = HashMap()

    /**
     * Gets current day
     * @return Day
     */
    @JvmStatic
    fun getCurrentDay(): Day{
        return days[days.size]!!
    }

    /**
     * Changes year to next one
     */
    @JvmStatic
    fun nextYear(){
        which += 1
        days.clear()
        weeks.clear()
        weeks.add(Week.builder().forMonth(Month.THERMIDOR).build())
        days.put(1, Day.IMIX)
    }

    /**
     * Gets current month
     * @return Month
     */
    @JvmStatic
    fun getCurrentMonth(): Month{
        return weeks[weeks.size-1].month!!
    }

}