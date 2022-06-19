package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.db.ArtistDao
import com.sriidea.udemyandroidlearning.data.db.MovieDao
import com.sriidea.udemyandroidlearning.data.db.TvShowsDao
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl.MovieLocalDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl.MoviesRemoteDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowsDao: TvShowsDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowsDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}