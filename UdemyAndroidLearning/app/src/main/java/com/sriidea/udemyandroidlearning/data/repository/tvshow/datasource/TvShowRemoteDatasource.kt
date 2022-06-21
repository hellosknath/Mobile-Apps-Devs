package com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource

import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
   suspend fun getTvShows(): Response<TvShowList>
}