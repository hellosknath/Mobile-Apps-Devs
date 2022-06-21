package com.sriidea.udemyandroidlearning.domain.repository

import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}