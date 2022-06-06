package com.sriidea.udemyandroidlearning

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            CoroutineScope(Dispatchers.IO).launch {
                btnDownloadUserData()
            }

        }

    }

    private suspend fun btnDownloadUserData() {
        for (i in 1..2000) {
            for (j in 1..10) {
                withContext(Dispatchers.Main) {
                    var dt = ""
                    dt += "$i x $j = ${i * j}\n"
                    userMessage.text = dt
                    Log.i(TAG, dt)
                }
            }
        }
    }
}