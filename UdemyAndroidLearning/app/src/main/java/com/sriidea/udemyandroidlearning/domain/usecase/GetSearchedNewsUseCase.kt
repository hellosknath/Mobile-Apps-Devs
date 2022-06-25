package com.sriidea.udemyandroidlearning.domain.useCase

import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.util.Resource
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchedQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchedQuery)
    }
}