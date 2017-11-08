package com.jatti.time

class Date(val month:Month, val year: Int, val week: Week) {

    fun whichDay(): Int{

        val days = month.weeksAmount*8

        //TODO
        return 0
    }

    fun checkWhenNextWeek(): Int {

        if (week.currentDay.ordinal < Day.ZEHTA.ordinal) {
            return (Day.ZEHTA.ordinal - week.currentDay.ordinal)+1
        }

        if (week.currentDay.ordinal == Day.ZEHTA.ordinal) {
            //TODO Houres
        }

        return 8
    }

    fun checkIfNextYear(): Boolean{

        if(week.month == Month.ENDIVE){


        }
        return false
    }

    companion object {
        @JvmStatic
        fun toDate(month: Month, year: Int, week: Week): Date {
            return Date(month, year, week)
        }

        @JvmStatic
        fun toNamedString(date: Date): String {
            return "${date.week.currentDay}/${date.month}/${date.year}"
        }

        @JvmStatic
        fun toNotNamedString(date: Date): String {
            return "${date.week.currentDay.ordinal}/${date.month.ordinal+1}/${date.year}"
        }

        @JvmStatic
        fun getNextDays(day: Day, amount: Int): List<Day>?{
            //TODO
            return null
        }
    }
}