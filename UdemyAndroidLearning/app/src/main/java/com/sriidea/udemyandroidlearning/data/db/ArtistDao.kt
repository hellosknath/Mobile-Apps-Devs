package com.sriidea.udemyandroidlearning.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sriidea.udemyandroidlearning.data.model.artist.Artist
import com.sriidea.udemyandroidlearning.data.model.movie.Movie

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getAllArtist(): List<Artist>

}