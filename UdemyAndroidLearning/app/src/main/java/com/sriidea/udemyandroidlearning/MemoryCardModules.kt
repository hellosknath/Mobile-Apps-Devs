package com.sriidea.udemyandroidlearning

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModules(val memorySize: Int) {

    @Provides
    fun provideMemoryCard(): MemoryCard {
        Log.i("MYTAG", "Size of the memory is $memorySize")
        return MemoryCard()
    }
}