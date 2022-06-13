package com.sriidea.udemyandroidlearning

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteryModule {
    @Binds
    abstract fun providesNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}