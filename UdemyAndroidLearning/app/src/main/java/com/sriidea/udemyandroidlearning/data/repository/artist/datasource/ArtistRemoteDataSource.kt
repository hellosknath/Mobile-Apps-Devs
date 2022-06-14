package com.sriidea.udemyandroidlearning.data.repository.artist.datasource

import com.sriidea.udemyandroidlearning.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}