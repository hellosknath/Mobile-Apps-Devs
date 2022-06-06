package com.sriidea.udemyandroidlearning.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "Ruman"),
            User(2, "Arif"),
            User(3, "Nipu"),
            User(4, "Uzzal"),
        )
        return users
    }
}