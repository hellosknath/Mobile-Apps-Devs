package com.sriidea.udemyandroidlearning

import android.util.Log
import javax.inject.Inject

class MemoryCard @Inject constructor() {
    init {
        Log.i("MYTAG", " Memory card constructed...")
    }

    fun getSpaceAvailable() {
        Log.i("MYTAG", "Memory space available")
    }
}