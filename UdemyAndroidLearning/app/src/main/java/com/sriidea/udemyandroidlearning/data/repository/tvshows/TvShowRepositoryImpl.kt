package com.sriidea.udemyandroidlearning.data.repository.tvshows

import android.util.Log
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShowList
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.sriidea.udemyandroidlearning.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val tvShowList = getTvShowsFromApi();
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDb(tvShowList)
        tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        return tvShowList
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body: TvShowList? = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDb(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDb()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDb(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
        }

        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDb()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}