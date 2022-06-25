package com.sriidea.udemyandroidlearning.domain.useCase

import com.sriidea.udemyandroidlearning.data.model.Article
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}