package com.sriidea.udemyandroidlearning

import dagger.Component

@Component(modules = [MemoryCardModules::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone
}