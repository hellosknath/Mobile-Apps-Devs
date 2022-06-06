package com.sriidea.udemyandroidlearning

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var count = 0
    private lateinit var userMessage: TextView
    private lateinit var countMsg: TextView
    private lateinit var btnDownload: Button
    private lateinit var btnCount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userMessage = findViewById(R.id.tvUserMessage)
        countMsg = findViewById(R.id.tvCount)
        btnCount = findViewById(R.id.btnCount)
        btnDownload = findViewById(R.id.btnDownloadUserData)

        btnCount.setOnClickListener {
            countMsg.text = count++.toString()
        }

        btnDownload.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                userMessage.text = UserDataManagerTwo().getTotalCount().toString()
            }

        }

    }

    private suspend fun btnDownloadUserData() {
        for (i in 1..2000) {
            for (j in 1..10) {
                withContext(Main) {
                    var dt = ""
                    dt += "$i x $j = ${i * j}\n"
                    userMessage.text = dt
                    Log.i(TAG, dt)
                }
            }
        }
    }
}