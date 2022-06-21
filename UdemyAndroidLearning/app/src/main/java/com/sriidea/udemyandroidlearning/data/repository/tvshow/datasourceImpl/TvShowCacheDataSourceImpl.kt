package com.sriidea.udemyandroidlearning.data.repository.tvshow.datasourceImpl

import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShow
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl :
    TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
       tvShowList.clear()
       tvShowList = ArrayList(tvShows)
    }
}