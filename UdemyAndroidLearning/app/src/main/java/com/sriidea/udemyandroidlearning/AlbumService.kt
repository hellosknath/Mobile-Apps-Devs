package com.sriidea.udemyandroidlearning

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbum(): Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbum(@Query("userId") userId: Int): Response<Albums>
}