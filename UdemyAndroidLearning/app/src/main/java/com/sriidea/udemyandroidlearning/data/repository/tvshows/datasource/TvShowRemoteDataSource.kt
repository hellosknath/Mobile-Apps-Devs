package com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource

import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}