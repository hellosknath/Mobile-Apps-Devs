package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.api.TMDBService
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl.MoviesRemoteDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MoviesRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}