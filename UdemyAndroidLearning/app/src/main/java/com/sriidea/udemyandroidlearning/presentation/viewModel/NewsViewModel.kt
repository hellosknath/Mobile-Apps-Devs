package com.sriidea.udemyandroidlearning.presentation.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sriidea.udemyandroidlearning.data.model.APIResponse
import com.sriidea.udemyandroidlearning.data.model.Article
import com.sriidea.udemyandroidlearning.data.util.Resource
import com.sriidea.udemyandroidlearning.domain.usecase.GetNewsHeadLinesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetSavedNewsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.GetSearchedNewsUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.SaveNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Query

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadLinesUseCase: GetNewsHeadLinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val savedNewsUseCase: SaveNewsUseCase
) : AndroidViewModel(app) {
    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadLine(country: String, page: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            newsHeadLines.postValue(Resource.Loading())
            try {
                if (isNetworkAvailable(app)) {
                    val apiResult = getNewsHeadLinesUseCase.execute(country, page)
                    newsHeadLines.postValue(apiResult)
                } else {
                    newsHeadLines.postValue(Resource.Error("Internet in not available"))
                }
            } catch (e: Exception) {
                newsHeadLines.postValue(Resource.Error(e.message.toString()))
            }

        }


    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }

        return false

    }

    //search
    val searchedNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun searchedNews(country: String, searchQuery: String, page: Int) = viewModelScope.launch {
        searchedNews.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val response = getSearchedNewsUseCase.execute(country, searchQuery, page)
                searchedNews.postValue(response)
            } else {
                searchedNews.postValue(Resource.Error("No Internet connection"))
            }
        } catch (e: Exception) {
            searchedNews.postValue(Resource.Error(e.message.toString()))
        }

    }

    // local data
    fun saveArticle(article: Article) = viewModelScope.launch {
        savedNewsUseCase.execute(article)
    }

}