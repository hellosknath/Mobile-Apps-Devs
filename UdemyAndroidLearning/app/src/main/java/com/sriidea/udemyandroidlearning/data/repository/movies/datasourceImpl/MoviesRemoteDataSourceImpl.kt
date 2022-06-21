package com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl

import com.sriidea.udemyandroidlearning.data.api.TMDBService
import com.sriidea.udemyandroidlearning.data.model.movie.MovieList
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MoviesRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList>{
     return tmdbService.getPopularMovies(apiKey)
    }

}