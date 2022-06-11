package com.sriidea.udemyandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            val response: Response<Albums> = restService.getAlbum()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList: MutableListIterator<AlbumsItem>? = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumsItem: AlbumsItem = albumList.next()
                    Log.i(TAG, "title: " + albumsItem.userId)
                    Log.i(TAG, "title: " + albumsItem.id)
                    Log.i(TAG, "title: " + albumsItem.title)
                    Log.i(TAG, "-----------------------------")
                }
            }
        })

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}