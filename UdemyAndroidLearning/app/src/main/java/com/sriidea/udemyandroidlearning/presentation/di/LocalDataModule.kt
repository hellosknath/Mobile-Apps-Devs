package com.sriidea.udemyandroidlearning.presentation.di

import com.sriidea.udemyandroidlearning.data.db.ArticleDao
import com.sriidea.udemyandroidlearning.data.repository.dataSource.NewsLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}