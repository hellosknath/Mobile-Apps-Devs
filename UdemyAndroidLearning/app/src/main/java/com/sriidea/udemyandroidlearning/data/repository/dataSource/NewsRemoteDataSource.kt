package com.sriidea.udemyandroidlearning.data.repository.dataSource

import com.sriidea.udemyandroidlearning.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse>
}