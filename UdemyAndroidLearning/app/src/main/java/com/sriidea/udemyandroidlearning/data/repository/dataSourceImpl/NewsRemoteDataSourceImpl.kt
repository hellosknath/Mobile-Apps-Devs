package com.sriidea.udemyandroidlearning.data.repository.dataSourceImpl

import com.sriidea.udemyandroidlearning.data.api.NewAPIService
import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newAPIService: NewAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<APIResponse> {
        return newAPIService.getTopHeadLines(country, page)
    }
}