package com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource

import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
  suspend fun getTvShowsFromDB():List<TvShow>
  suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
  suspend fun clearAll()
}