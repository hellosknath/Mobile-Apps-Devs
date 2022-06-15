package com.sriidea.udemyandroidlearning.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sriidea.udemyandroidlearning.domain.usecase.GetMoviesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMovisUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovisUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val updateMovieList = updateMoviesUseCase.execute()
        emit(updateMovieList)
    }

}