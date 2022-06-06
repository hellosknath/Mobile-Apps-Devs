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
            btnDownloadUserData()
        }

    }

    private fun btnDownloadUserData() {
        for (i in 1..20000000) {
            Log.i(TAG, "Downloading user data $i in ${Thread.currentThread().name}")
        }
    }
}