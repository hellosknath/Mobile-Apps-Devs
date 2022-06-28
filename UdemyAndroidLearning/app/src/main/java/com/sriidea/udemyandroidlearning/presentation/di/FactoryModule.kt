package com.sriidea.udemyandroidlearning.presentation.di

import android.app.Application
import com.sriidea.udemyandroidlearning.domain.usecase.GetNewsHeadLinesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetSearchedNewsUseCase
import com.sriidea.udemyandroidlearning.presentation.NewsApp
import com.sriidea.udemyandroidlearning.presentation.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadLinesUseCase, getSearchedNewsUseCase)
    }
}