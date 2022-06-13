package com.sriidea.udemyandroidlearning

import android.util.Log

class MemoryCard {
    init {
        Log.i("MYTAG", " Memory card constructed...")
    }

    fun getSpaceAvailable() {
        Log.i("MYTAG", "Memory space available")
    }
}