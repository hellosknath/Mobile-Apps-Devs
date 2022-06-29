package com.sriidea.udemyandroidlearning.data.repository

import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.model.Article
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsRemoteDataSource
import com.sriidea.udemyandroidlearning.data.util.Resource
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun getNewsHeadLines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchedQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedNews(
                country,
                searchedQuery,
                page
            )
        )
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }


    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDb(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticleFromDb(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSaveArticles()
    }
}