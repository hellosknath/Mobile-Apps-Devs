package com.sriidea.udemyandroidlearning.data.repository.tvshows.datasourceImpl

import com.sriidea.udemyandroidlearning.data.db.TvShowsDao
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowsDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDb(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}