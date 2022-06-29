package com.sriidea.udemyandroidlearning.data.repository.dataSource

import com.sriidea.udemyandroidlearning.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticleToDb(article: Article)
    fun getSaveArticles(): Flow<List<Article>>
    suspend fun deleteArticleFromDb(article: Article)

}