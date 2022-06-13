package com.sriidea.udemyandroidlearning

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor(){
    init {
        Log.i("MYTAG", "Service provider constructed...")
    }

    fun getServiceProvider() {
        Log.i("MYTAG", "Service provider connected.")
    }
}