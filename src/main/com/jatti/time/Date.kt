package com.jatti.time

object Date{

    @JvmStatic
    fun getCurrentDate(): String{
        return "${Year.getCurrentDay()}/${Year.getCurrentMonth()}/${Year.which}"
    }

    @JvmStatic
    fun getNamedCurrentDate(): String{
        return "${Year.getCurrentDay().name.toLowerCase()}/${Year.getCurrentMonth().name.toLowerCase()}/${Year.which}"
    }
}