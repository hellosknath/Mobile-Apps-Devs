package com.sriidea.udemyandroidlearning.presentation.di

import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository
import com.sriidea.udemyandroidlearning.domain.usecase.GetNewsHeadLinesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetSearchedNewsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadLineUseCase(newsRepository: NewsRepository):
            GetNewsHeadLinesUseCase {
        return GetNewsHeadLinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsUseCase(newsRepository: NewsRepository):
            GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(newsRepository: NewsRepository):
            SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }
}