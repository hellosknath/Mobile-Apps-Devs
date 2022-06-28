package com.sriidea.udemyandroidlearning.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sriidea.udemyandroidlearning.domain.usecase.GetNewsHeadLinesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetSearchedNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(app, getNewsHeadLinesUseCase, getSearchedNewsUseCase) as T
    }
}