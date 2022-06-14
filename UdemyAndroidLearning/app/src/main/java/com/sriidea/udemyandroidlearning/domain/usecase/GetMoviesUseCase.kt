package com.sriidea.udemyandroidlearning.domain.usecase

import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.domain.repository.MovieRepository

class GetMoviesUseCase(private val getMovieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = getMovieRepository.getMovies()
}