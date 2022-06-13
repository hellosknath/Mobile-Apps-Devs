package com.sriidea.udemyandroidlearning

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor(
    val battery: Battery,
    val memoryCard: MemoryCard,
    val simCard: SIMCard
) {

    init {
        battery.getPower()
        memoryCard.getSpaceAvailable()
        simCard.getConnection()
        Log.i("MYTAG", "SmartPhone Constructed...")
    }

    fun makeCallWithRecording() {
        Log.i("MYTAG", "Calling....")
    }
}