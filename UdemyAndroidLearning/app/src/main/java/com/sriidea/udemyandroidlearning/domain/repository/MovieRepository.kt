package com.sriidea.udemyandroidlearning.domain.repository

import com.sriidea.udemyandroidlearning.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?

}