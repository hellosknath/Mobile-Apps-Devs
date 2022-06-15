package com.sriidea.udemyandroidlearning.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sriidea.udemyandroidlearning.domain.usecase.GetArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetMoviesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateartist() = liveData {
        val updateartistList = updateArtistUseCase.execute()
        emit(updateartistList)
    }

}