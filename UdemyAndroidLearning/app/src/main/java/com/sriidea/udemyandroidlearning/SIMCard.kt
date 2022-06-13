package com.sriidea.udemyandroidlearning

import android.util.Log
import javax.inject.Inject

class SIMCard @Inject constructor(private val serviceProvider: ServiceProvider) {
    init {
        Log.i("MYTAG", "SIM card constructed...")
    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}