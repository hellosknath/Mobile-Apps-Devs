package com.sriidea.udemyandroidlearning.data.repository.artist.datasource

import com.sriidea.udemyandroidlearning.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}