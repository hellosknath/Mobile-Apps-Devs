package com.sriidea.udemyandroidlearning

import android.app.Application

class SmartPhoneApplication : Application() {

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()
        smartPhoneComponent = initDagger()
    }

    private fun initDagger(): SmartPhoneComponent =
        DaggerSmartPhoneComponent.builder()
            .memoryCardModules(MemoryCardModules(10000))
            .build()
}