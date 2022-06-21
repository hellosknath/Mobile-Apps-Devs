package com.sriidea.udemyandroidlearning.data.repository.movie.datasource

import com.sriidea.udemyandroidlearning.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
   suspend fun getMovies(): Response<MovieList>
}