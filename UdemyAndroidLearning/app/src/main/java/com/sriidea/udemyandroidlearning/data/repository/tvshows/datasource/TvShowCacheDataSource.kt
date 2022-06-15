package com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource

import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}