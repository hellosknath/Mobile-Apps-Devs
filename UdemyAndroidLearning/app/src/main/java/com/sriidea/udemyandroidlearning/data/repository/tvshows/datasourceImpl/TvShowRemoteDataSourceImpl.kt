package com.sriidea.udemyandroidlearning.data.repository.tvshows.datasourceImpl

import com.sriidea.udemyandroidlearning.data.api.TMDBService
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShowList
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}