package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.util.Resource
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, searchedQuery: String, page: Int): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, searchedQuery, page)
    }
}