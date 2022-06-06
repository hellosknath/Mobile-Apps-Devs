package com.sriidea.udemyandroidlearning

import kotlinx.coroutines.*

class UserDataManagerTwo {

    var count = 0
    lateinit var deferred: Deferred<Int>
    suspend fun getTotalCount(): Int {
        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }

            deferred = async(Dispatchers.IO) {
                delay(3000)
                return@async 70
            }
        }

        return count + deferred.await()
    }
}