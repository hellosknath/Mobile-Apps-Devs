package com.sriidea.udemyandroidlearning

import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun providesDataSource(): DataSource{
        return DataSource()
    }
}