package com.sriidea.udemyandroidlearning.data.repository.movie.datasource

import com.sriidea.udemyandroidlearning.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)

}