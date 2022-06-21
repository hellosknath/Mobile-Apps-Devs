package com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource

import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)

}