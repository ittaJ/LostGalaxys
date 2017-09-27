package com.jatti.achievements.missions

import com.jatti.achievements.prize.Prize

interface Mission {

    //TODO Make it working

    var value:Int
    var name:String
    var isChallenge:Boolean
    var prize: Prize
    fun onGet()
    fun onComplete()

}