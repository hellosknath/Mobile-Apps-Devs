package com.sriidea.udemyandroidlearning.presentation.di

import com.sriidea.udemyandroidlearning.data.repository.NewsRepositoryImpl
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsRemoteDataSource
import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}