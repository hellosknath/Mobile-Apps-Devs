package com.sriidea.udemyandroidlearning.presentation.di.artist

import com.sriidea.udemyandroidlearning.domain.usecase.GetArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateArtistUseCase
import com.sriidea.udemyandroidlearning.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }
}