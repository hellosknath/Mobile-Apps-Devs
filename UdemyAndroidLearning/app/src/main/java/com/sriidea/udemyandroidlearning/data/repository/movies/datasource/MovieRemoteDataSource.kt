package com.sriidea.udemyandroidlearning.data.repository.movies.datasource

import com.sriidea.udemyandroidlearning.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}