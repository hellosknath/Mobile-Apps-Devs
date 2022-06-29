package com.sriidea.udemyandroidlearning.data.repository.dataSourceImpl

import com.sriidea.udemyandroidlearning.data.db.ArticleDao
import com.sriidea.udemyandroidlearning.data.model.Article
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDataSource {
    override suspend fun saveArticleToDb(article: Article) {
        articleDao.insert(article)
    }

    override fun getSaveArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticleFromDb(article: Article) {
        articleDao.deleteArticle(article)
    }

}