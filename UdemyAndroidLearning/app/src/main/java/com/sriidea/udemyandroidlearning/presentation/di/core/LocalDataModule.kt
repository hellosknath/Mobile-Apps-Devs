package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.db.ArtistDao
import com.sriidea.udemyandroidlearning.data.db.MovieDao
import com.sriidea.udemyandroidlearning.data.db.TvShowDao
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.movie.datasource.MovieLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
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
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }


}