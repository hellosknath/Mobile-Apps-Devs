package com.sriidea.udemyandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var restService: AlbumService
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        // getting album service instance
        restService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

//        getRequestWithQueryParameter()
//        getRequestWithPathParameter()
        uploadAlbum()
    }

    fun getRequestWithQueryParameter() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response: Response<Albums> = restService.getSortedAlbum(3)
            emit(response)
        }


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

    fun getRequestWithPathParameter() {
        // path parameter example
        val pathResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response: Response<AlbumsItem> = restService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title: String? = it.body()?.title
            Toast.makeText(applicationContext, "Title: $title", Toast.LENGTH_SHORT).show()
        })

    }

    private fun uploadAlbum() {
        val album = AlbumsItem(0, "Srinath", 101)
        val postRequest: LiveData<Response<AlbumsItem>> = liveData {
            val response = restService.uploadAlbum(album)
            emit(response)
        }
        postRequest.observe(this, Observer {
            val received: AlbumsItem? = it.body()
            val result: String =
                " " + "Album Title: ${received?.title}" + "\n" +
                        " " + "Album id: ${received?.id}" + "\n" +
                        " " + "user id: ${received?.userId}" + "\n\n\n"
            textView.text = result
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}