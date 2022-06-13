package com.sriidea.udemyandroidlearning

import android.util.Log

class SIMCard(private val serviceProvider: ServiceProvider) {
    init {
        Log.i("MYTAG", "SIM card constructed...")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}