package com.sriidea.udemyandroidlearning.data.api

import com.sriidea.udemyandroidlearning.BuildConfig
import com.sriidea.udemyandroidlearning.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewAPIService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>

    @GET("/v2/top-headlines")
    suspend fun getSearchedTopHeadLines(
        @Query("country")
        country: String,
        @Query("q")
        searchQuery: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>

}