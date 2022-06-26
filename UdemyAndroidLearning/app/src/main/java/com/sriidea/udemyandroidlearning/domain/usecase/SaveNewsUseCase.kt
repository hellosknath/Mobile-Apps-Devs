package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.Article
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository

class SaveNewsUseCase(private val repository: NewsRepository) {
    suspend fun execute(article: Article) = repository.saveNews(article)
}