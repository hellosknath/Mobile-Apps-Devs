package com.sriidea.udemyandroidlearning.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sriidea.udemyandroidlearning.data.model.artist.Artist
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.model.tvshows.TvShow

@Database(
    entities = [Movie::class, Artist::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowsDao(): TvShowsDao
    abstract fun artistDao(): ArtistDao
}