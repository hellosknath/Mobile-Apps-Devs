package com.sriidea.udemyandroidlearning.presentation.di

import com.sriidea.udemyandroidlearning.domain.repository.NewsRepository
import com.sriidea.udemyandroidlearning.domain.usecase.GetNewsHeadLinesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetNewsHeadLineUseCase(newsRepository: NewsRepository):
            GetNewsHeadLinesUseCase {
        return GetNewsHeadLinesUseCase(newsRepository)
    }
}