package com.sriidea.udemyandroidlearning.presentation.di.artist

import com.sriidea.udemyandroidlearning.domain.usecase.GetArtistsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateArtistsUseCase
import com.sriidea.udemyandroidlearning.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}