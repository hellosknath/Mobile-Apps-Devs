package com.sriidea.udemyandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        // use dependency injection
        DaggerSmartPhoneComponent.create().inject(this)
        smartPhone.makeCallWithRecording()
        memoryCard.getSpaceAvailable()*/

        /*  // using state of a module
          DaggerSmartPhoneComponent.builder()
              .memoryCardModules(MemoryCardModules(10000))
              .build()
              .inject(this)*/

        (application as SmartPhoneApplication).smartPhoneComponent.inject(this)

    }
}