package com.sriidea.udemyandroidlearning.data.repository.dataSource

import com.sriidea.udemyandroidlearning.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticleToDb(article: Article)
}