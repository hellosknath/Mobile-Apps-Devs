package com.sriidea.udemyandroidlearning.data.repository.tvshows.datasourceImpl

import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowCacheDataSource


class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}