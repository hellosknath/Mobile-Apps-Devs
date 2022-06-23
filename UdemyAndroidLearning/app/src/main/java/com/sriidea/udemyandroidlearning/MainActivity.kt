package com.sriidea.udemyandroidlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sriidea.udemyandroidlearning.MyBackgroundService.Companion.MARKS
import com.sriidea.udemyandroidlearning.MyBackgroundService.Companion.NAME
import com.sriidea.udemyandroidlearning.MyBackgroundService.Companion.TAG
import com.sriidea.udemyandroidlearning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME,"SRINATH")
        serviceIntent.putExtra(MARKS,90)
        binding.btnStart.setOnClickListener {
            Log.i(MainActivity.TAG,"Starting service...")
            startService(serviceIntent)
        }

        binding.btnEnd.setOnClickListener {
            Log.i(MainActivity.TAG,"Stopping service...")
            stopService(serviceIntent)
        }
    }

    companion object {
        private const val TAG = "MYTAG"
    }
}