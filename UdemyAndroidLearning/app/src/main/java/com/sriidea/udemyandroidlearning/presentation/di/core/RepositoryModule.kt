package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.repository.artist.ArtistRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistRemoteDatasource
import com.sriidea.udemyandroidlearning.data.repository.movie.MovieRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.movie.datasource.MovieCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.movie.datasource.MovieLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.movie.datasource.MovieRemoteDatasource
import com.sriidea.udemyandroidlearning.data.repository.tvshow.TvShowRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.sriidea.udemyandroidlearning.domain.repository.ArtistRepository
import com.sriidea.udemyandroidlearning.domain.repository.MovieRepository
import com.sriidea.udemyandroidlearning.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }

}