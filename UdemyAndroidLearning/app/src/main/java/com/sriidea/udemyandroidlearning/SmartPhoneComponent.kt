package com.sriidea.udemyandroidlearning

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModules::class, NCBatteryModule::class])
interface SmartPhoneComponent {
    fun inject(mainActivity: MainActivity)
}