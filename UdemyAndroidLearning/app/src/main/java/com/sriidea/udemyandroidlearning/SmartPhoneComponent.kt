package com.sriidea.udemyandroidlearning

import dagger.Component

@Component(modules = [MemoryCardModules::class, NCBatteryModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone
}