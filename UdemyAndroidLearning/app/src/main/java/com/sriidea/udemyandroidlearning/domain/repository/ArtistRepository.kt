package com.sriidea.udemyandroidlearning.domain.repository

import com.sriidea.udemyandroidlearning.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}