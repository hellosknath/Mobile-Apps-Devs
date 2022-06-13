package com.sriidea.udemyandroidlearning

import android.util.Log

class SmartPhone(val battery: Battery, val memoryCard: MemoryCard, val simCard: SIMCard) {

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