package com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource

import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb(): List<TvShow>
    suspend fun saveTvShowsToDb(tvShows: List<TvShow>)
    suspend fun clearAll()
}