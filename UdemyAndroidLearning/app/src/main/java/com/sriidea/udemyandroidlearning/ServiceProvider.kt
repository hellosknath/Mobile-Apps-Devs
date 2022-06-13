package com.sriidea.udemyandroidlearning

import android.util.Log

class ServiceProvider {
    init {
        Log.i("MYTAG", "Service provider constructed...")
    }

    fun getServiceProvider() {
        Log.i("MYTAG", "Service provider connected.")
    }
}