package com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl

import com.sriidea.udemyandroidlearning.data.api.TMDBService
import com.sriidea.udemyandroidlearning.data.model.artist.ArtistList
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val apiTMDBService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> =
        apiTMDBService.getPopularPerson(apiKey)
}