package com.sriidea.udemyandroidlearning.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sriidea.udemyandroidlearning.domain.usecase.GetTvShowsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

 fun getTvShows() = liveData {
     val tvShowList = getTvShowsUseCase.execute()
     emit(tvShowList)
 }

 fun updateTvShows() = liveData {
     val tvShowList = updateTvShowsUseCase.execute()
     emit(tvShowList)
 }
}
