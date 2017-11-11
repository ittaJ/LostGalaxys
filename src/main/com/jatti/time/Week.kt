package com.jatti.time

/**
 * Class for Weeks
 * @author Jatti
 * @version 1.1
 */
class Week{

    var month:Month? = null
    var currentDay:Day = Day.IMIX

    /**
     * Creates new WeekBuilder
     * @return WeeekBuilder
     */
    companion object {
        @JvmStatic
        fun builder():WeekBuilder{
            return WeekBuilder()
        }
    }

}

/**
 *  Builder for weeks
 *  @author Jatti
 *  @version 1.1
 */
class WeekBuilder{

    private var week = Week()

    /**
     * Sets month for which is this week
     * @param month
     */
    fun forMonth(month: Month): WeekBuilder{
        week.month = month
        return this
    }

    /**
     * Sets current day
     * @param day current day
     */
    fun currentDay(day: Day): WeekBuilder{
        if(week.currentDay.name == day.name){
            error("This day is already current day!")
        }

        if(week.currentDay.ordinal >= day.ordinal){
            error("This day can't be current day!")
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
        week.month!!.nextWeek()
        return week
    }

    /**
     * Creates new week without changing it in month
     * @return Week
     */
    fun freeBuild(): Week{
        return week
    }
}

/**fun main(args: Array<String>){
    println(Month.MIEL.weeks.size)
    println("-------")
    val m = Week.builder().forMonth(Month.MIEL).build()
    println(Month.MIEL.weeks.size)
    println(m.currentDay.name)
    println(m.month!!.name)
    println("------")
    m.currentDay = m.currentDay.nextDay()
    println(m.currentDay)
    println("--------")
    m.currentDay = Day.ZEHTA
    println(m.currentDay)
    m.currentDay = m.currentDay.nextDay()
    println(m.currentDay)
    println("--------")
    Year.nextYear()
    val y = Year
    println(y.which)
    println(y.days.size)
    println(y.days.values)
    println(y.days.keys)
    println(y.weeks.size)
    println(y.weeks)
    println(y.getCurrentDay())
    println("-------")
    y.getCurrentDay().nextDay()
    println(y.days.size)
    println(y.days.values)
    println(y.days.keys)
    println(y.weeks.size)
    println(y.weeks)
    println(y.getCurrentDay())
    println("--------")
    Week.builder().forMonth(Month.MIEL).build()
    println(y.getCurrentMonth())

}**/