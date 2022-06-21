package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.movie.datasource.MovieCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}