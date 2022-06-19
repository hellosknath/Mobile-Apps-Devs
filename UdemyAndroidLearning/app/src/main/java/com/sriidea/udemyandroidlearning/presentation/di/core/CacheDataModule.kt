package com.sriidea.udemyandroidlearning.presentation.di.core

import com.sriidea.udemyandroidlearning.data.repository.artist.datasource.ArtistCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MoviesCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl.MovieCacheDataSourceImpl
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.sriidea.udemyandroidlearning.data.repository.tvshows.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MoviesCacheDataSource {
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
        return ArtistCacheDatasourceImpl()
    }
}