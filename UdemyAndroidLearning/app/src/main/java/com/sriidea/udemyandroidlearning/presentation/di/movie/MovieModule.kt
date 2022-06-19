package com.sriidea.udemyandroidlearning.presentation.di.movie

import com.sriidea.udemyandroidlearning.domain.usecase.GetArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetMoviesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateArtistUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateMoviesUseCase
import com.sriidea.udemyandroidlearning.presentation.artist.ArtistViewModelFactory
import com.sriidea.udemyandroidlearning.presentation.movies.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}