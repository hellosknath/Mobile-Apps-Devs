package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.repository.artist.ArtistRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.MovieRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MoviesCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.TvShowRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowRemoteDataSource
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
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        moviesCacheDataSource: MoviesCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            moviesCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowLocalDataSource,
            tvShowRemoteDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistCacheDataSource: ArtistCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistCacheDataSource,
            artistLocalDataSource,
            artistRemoteDataSource
        )
    }

}