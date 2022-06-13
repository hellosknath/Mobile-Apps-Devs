package com.sriidea.udemyandroidlearning

import android.util.Log

class Battery {
    init {
        Log.i("MYTAG", "Battery Constructed...")
    }

    fun getPower() {
        Log.i("MYTAG", "Battery Power is available")
    }
}