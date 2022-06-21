package com.sriidea.udemyandroidlearning.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sriidea.udemyandroidlearning.data.model.artist.Artist
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShow


@Database(entities = [Movie::class, TvShow::class, Artist::class],
version = 2,
exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase(){
abstract fun movieDao(): MovieDao
abstract fun tvDao(): TvShowDao
abstract fun artistDao(): ArtistDao

}