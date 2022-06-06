package com.sriidea.udemyandroidlearning

import kotlinx.coroutines.*

class UserDataManager {

    suspend fun getTotalUserCount(): Int {
        var count = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            count = 50
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            delay(3000)
            return@async 70
        }
        return count + deferred.await()
    }


}