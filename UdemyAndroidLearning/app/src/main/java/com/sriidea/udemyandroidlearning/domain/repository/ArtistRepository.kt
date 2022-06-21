package com.sriidea.udemyandroidlearning.domain.repository

import com.sriidea.udemyandroidlearning.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}