package com.sriidea.udemyandroidlearning

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor() {
    init {
        Log.i("MYTAG", "Battery Constructed...")
    }

    fun getPower() {
        Log.i("MYTAG", "Battery Power is available")
    }
}