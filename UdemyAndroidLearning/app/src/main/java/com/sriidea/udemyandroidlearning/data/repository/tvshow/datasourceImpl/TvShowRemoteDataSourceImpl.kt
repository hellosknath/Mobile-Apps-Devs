package com.sriidea.udemyandroidlearning.data.repository.tvshow.datasourceImpl

import com.sriidea.udemyandroidlearning.data.api.TMDBService
import com.sriidea.udemyandroidlearning.data.model.tvshow.TvShowList
import com.sriidea.udemyandroidlearning.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDatasource {
    override suspend fun getTvShows()
            : Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}

