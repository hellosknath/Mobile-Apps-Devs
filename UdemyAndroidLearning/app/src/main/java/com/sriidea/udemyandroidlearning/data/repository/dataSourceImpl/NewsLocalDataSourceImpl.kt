package com.sriidea.udemyandroidlearning.data.repository.dataSourceImpl

import com.sriidea.udemyandroidlearning.data.db.ArticleDao
import com.sriidea.udemyandroidlearning.data.model.Article
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDataSource {
    override suspend fun saveArticleToDb(article: Article) {
        articleDao.insert(article)
    }
}