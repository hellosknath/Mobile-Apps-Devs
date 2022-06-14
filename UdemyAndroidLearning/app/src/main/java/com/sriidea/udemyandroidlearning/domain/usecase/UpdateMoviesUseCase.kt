package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}