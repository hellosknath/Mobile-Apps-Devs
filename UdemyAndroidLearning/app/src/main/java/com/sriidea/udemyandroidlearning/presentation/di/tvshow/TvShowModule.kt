package com.sriidea.udemyandroidlearning.presentation.di.tvshow

import com.sriidea.udemyandroidlearning.domain.usecase.GetArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetTvShowsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateTvShowsUseCase
import com.sriidea.udemyandroidlearning.presentation.artist.ArtistViewModelFactory
import com.sriidea.udemyandroidlearning.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}