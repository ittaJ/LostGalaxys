package com.jatti.achievements.missions

import com.jatti.user.User

interface Mission {

    val value: Int
    val name: String
    fun onGet(user: User)
    fun onComplete(user: User)

}