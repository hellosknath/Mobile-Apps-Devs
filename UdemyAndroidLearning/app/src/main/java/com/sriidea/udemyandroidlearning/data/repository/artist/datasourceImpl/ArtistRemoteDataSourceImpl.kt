package com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl

import com.sriidea.udemyandroidlearning.data.api.TMDBService
import com.sriidea.udemyandroidlearning.data.model.artist.ArtistList
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDatasource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}

