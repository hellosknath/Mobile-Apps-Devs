package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.artist.Artist
import com.sriidea.udemyandroidlearning.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtist()
}