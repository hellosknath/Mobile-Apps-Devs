package com.sriidea.udemyandroidlearning

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.*

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            val count: Int = inputData.getInt(MainActivity.KEY_COUNT_VALUE, 0)
            for (i in 0 until count) {
                Log.i(TAG, "Uploading $i")
            }

            // sending dat to finished block
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())
            val putOutputData = Data.Builder()
                .putString(KEY_WORKER, currentDate)
                .build()

            Result.success(putOutputData)
        } catch (e: Exception) {
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "UploadWorker"
        const val KEY_WORKER = "key_worker"
    }
}