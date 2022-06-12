package com.sriidea.udemyandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_COUNT_VALUE = "key_count_value"
    }

    private lateinit var button: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        button.setOnClickListener {
            onetimeWorkRequest()
        }
    }

    private fun onetimeWorkRequest() {
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)

        val data: Data = Data.Builder()
            .putInt(KEY_COUNT_VALUE, 500)
            .build()

        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadRequest: OneTimeWorkRequest = OneTimeWorkRequest
            .Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        // create filtering and compressing class instance
        val filteringRequest = OneTimeWorkRequest.Builder(Filtering::class.java).build()
        val compressingRequest = OneTimeWorkRequest.Builder(Compressing::class.java).build()

        workManager
            .beginWith(filteringRequest)
            .then(compressingRequest)
            .then(uploadRequest)
            .enqueue()
        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this, Observer {
                textView.text = it.state.name

                // receiving data from worker class
                if (it.state.isFinished) {
                    val data = it.outputData
                    val message = data.getString(UploadWorker.KEY_WORKER)
                    Toast.makeText(applicationContext, "$message", Toast.LENGTH_SHORT).show()
                }

            })
    }
}