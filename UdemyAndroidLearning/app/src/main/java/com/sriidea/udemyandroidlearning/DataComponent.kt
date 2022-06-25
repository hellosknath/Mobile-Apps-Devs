package com.sriidea.udemyandroidlearning

import dagger.Component

@Component(modules = [DataModule::class])
interface DataComponent {
    fun inject(mainActivity: MainActivity)
}