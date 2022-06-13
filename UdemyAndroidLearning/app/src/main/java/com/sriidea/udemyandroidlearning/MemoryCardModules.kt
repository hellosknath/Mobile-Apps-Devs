package com.sriidea.udemyandroidlearning

import dagger.Module
import dagger.Provides

@Module
class MemoryCardModules {

    @Provides
    fun provideMemoryCard(): MemoryCard{
        return MemoryCard()
    }
}