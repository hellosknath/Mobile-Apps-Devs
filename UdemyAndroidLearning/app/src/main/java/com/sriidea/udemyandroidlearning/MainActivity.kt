package com.sriidea.udemyandroidlearning

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
            Log.i(TAG, "onCreate: Calculation Started...")
            val stock1 = async(IO) { getStock1() }
            val stock2 = async(IO) { getStock2() }
            val totalValue = stock1.await() + stock2.await()
            Toast.makeText(
                this@MainActivity,
                "onCreate: Total is $totalValue",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private suspend fun getStock1(): Int {
        delay(10000)
        Log.i(TAG, "getStock1: return")
        return 10000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.i(TAG, "getStock2: return")
        return 8000
    }
}