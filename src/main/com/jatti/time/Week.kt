package com.jatti.time

/**
 * Class for weeks
 * @author Jatti
 * @version 1.0
 */
class Week{

    var month:Month? = null
    var currentDay:Day = Day.IMIX

    companion object {

        /**
         * Creates new WeekBuilder
         */
        @JvmStatic
        fun builder():WeekBuilder{
            return WeekBuilder()
        }
    }

}

/**
 *  Builder for weeks
 *  @author Jatti
 *  @version 1.0
 */
class WeekBuilder{

    private var week = Week()


    /**
     * Sets month for which is this week
     * @param month
     */
    fun forMonth(month: Month): WeekBuilder{
        if(month.weeks.size == month.weeksAmount){
            error("this month has enough weeks, you can't add more")
        }
        month.weeks.add(week)
        week.month = month
        return this
    }

    /**
     * Sets current day
     * @param day current day
     */
    fun currentDay(day: Day): WeekBuilder{

        if(week.currentDay.name == day.name){
            error("this day is already current day!")
        }

        if(week.currentDay.ordinal >= day.ordinal){
            error("this day can't be current day!")
        }

        week.currentDay = day
        return this
    }

    /**
     * Makes builder from week
     * @param week which you want to change
     */
    fun fromWeek(week: Week): WeekBuilder{
        this.week = week
        return this
    }

    /**
     * Creates new week
     * @return Week
     */
    fun build(): Week{
        return week
    }
}
