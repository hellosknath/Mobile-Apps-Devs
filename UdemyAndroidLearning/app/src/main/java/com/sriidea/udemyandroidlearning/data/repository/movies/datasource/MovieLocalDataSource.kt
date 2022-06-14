package com.sriidea.udemyandroidlearning.data.repository.movies.datasource

import com.sriidea.udemyandroidlearning.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearAll()
}