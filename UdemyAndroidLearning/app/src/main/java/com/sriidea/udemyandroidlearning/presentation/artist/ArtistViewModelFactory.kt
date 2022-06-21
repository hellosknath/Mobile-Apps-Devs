package com.sriidea.udemyandroidlearning.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sriidea.udemyandroidlearning.domain.usecase.GetArtistsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateArtistsUseCase

class ArtistViewModelFactory(
    private val getArtistUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUseCase, updateArtistUseCase) as T
    }
}