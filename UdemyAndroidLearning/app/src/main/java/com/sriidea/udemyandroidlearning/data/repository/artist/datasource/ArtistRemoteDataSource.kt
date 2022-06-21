package com.sriidea.udemyandroidlearning.data.repository.artist.datasource

import com.sriidea.udemyandroidlearning.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
   suspend fun getArtists(): Response<ArtistList>
}