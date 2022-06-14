package com.sriidea.udemyandroidlearning.data.api

import com.sriidea.udemyandroidlearning.data.ArtistList
import com.sriidea.udemyandroidlearning.data.MovieList
import com.sriidea.udemyandroidlearning.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularPerson(@Query("api_key") apiKey: String): Response<ArtistList>
}