package com.sriidea.udemyandroidlearning.data.repository.movies.datasource

import com.sriidea.udemyandroidlearning.data.model.movie.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}