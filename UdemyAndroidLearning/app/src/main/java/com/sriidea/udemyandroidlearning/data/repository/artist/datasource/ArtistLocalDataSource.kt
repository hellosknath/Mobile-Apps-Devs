package com.sriidea.udemyandroidlearning.data.repository.artist.datasource

import com.sriidea.udemyandroidlearning.data.model.artist.Artist
import com.sriidea.udemyandroidlearning.data.model.artist.ArtistList

interface ArtistLocalDataSource {
    suspend fun getArtistFromDb(): List<Artist>
    suspend fun saveArtistToDb(artist: List<Artist>)
    suspend fun clearAll()
}