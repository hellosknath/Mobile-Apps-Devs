package com.sriidea.udemyandroidlearning.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow

@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getAllTvShows(): List<TvShow>

}