package com.sriidea.udemyandroidlearning.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sriidea.udemyandroidlearning.domain.usecase.GetMoviesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetTvShowsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateMoviesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val TvShowList = getTvShowsUseCase.execute()
        emit(TvShowList)
    }

    fun updateTvShows() = liveData {
        val updateTvShowsList = updateTvShowsUseCase.execute()
        emit(updateTvShowsList)
    }

}