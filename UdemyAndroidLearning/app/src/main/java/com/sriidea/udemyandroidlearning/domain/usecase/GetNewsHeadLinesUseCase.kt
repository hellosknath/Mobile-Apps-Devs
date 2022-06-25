package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.util.Resource
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository

class GetNewsHeadLinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadLines()
    }
}