package com.sriidea.udemyandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting album service instance
        val restService: AlbumService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response: Response<Albums> = restService.getSortedAlbum(3)
            emit(response)
        }

        val textView: TextView = findViewById(R.id.textView)
        responseLiveData.observe(this, Observer {
            val albumList: MutableListIterator<AlbumsItem>? = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumsItem: AlbumsItem = albumList.next()
                    Log.i(TAG, "title: " + albumsItem.title)
                    val result: String =
                        " " + "Album Title: ${albumsItem.title}" + "\n" +
                                " " + "Album id: ${albumsItem.id}" + "\n" +
                                " " + "user id: ${albumsItem.userId}" + "\n\n\n"
                    textView.append(result)

                }
            }
        })

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}