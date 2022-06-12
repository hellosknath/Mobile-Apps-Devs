package com.sriidea.udemyandroidlearning

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class Downloading(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            for (i in 0..5000) {
                Log.i(TAG, "Downloading $i")
            }

            // sending dat to finished block
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())
            Log.i(TAG, "$currentDate")

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "UploadWorker"
        const val KEY_WORKER = "key_worker"
    }
}