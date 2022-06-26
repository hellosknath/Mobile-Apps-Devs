package com.sriidea.udemyandroidlearning.presentation.di

import com.sriidea.udemyandroidlearning.data.api.NewAPIService
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideNewsRemoteDataSource(newAPIService: NewAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newAPIService)
    }
}