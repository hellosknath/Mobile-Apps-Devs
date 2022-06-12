package com.sriidea.udemyandroidlearning

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView2 = findViewById(R.id.textView2)
        receiveInput()
    }

    private fun receiveInput() {
        val KEY_REPLY = "key_reply"
        val intent = this.intent
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        if (remoteInput != null) {
            val inputString = remoteInput.getCharSequence(KEY_REPLY).toString()
            textView2.text = inputString

            val channelId = "com.sriidea.udemyandroidlearning.channel1"
            val notificationId = 10
            val repliedNotification = NotificationCompat.Builder(
                this,
                channelId
            ).setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentText("your Reply received")
                .build()
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE)
                        as NotificationManager
            notificationManager.notify(notificationId, repliedNotification)
        }
    }
}