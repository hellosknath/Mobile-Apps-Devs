package com.sriidea.udemyandroidlearning.data.repository.dataSourceImpl

import com.sriidea.udemyandroidlearning.data.api.NewAPIService
import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newAPIService: NewAPIService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newAPIService.getTopHeadLines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newAPIService.getSearchedTopHeadLines(country, searchedQuery, page)
    }
}