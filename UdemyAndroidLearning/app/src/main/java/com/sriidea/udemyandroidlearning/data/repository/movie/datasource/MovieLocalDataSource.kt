package com.sriidea.udemyandroidlearning.data.repository.movie.datasource

import com.sriidea.udemyandroidlearning.data.model.movie.Movie

interface MovieLocalDataSource {
  suspend fun getMoviesFromDB():List<Movie>
  suspend fun saveMoviesToDB(movies:List<Movie>)
  suspend fun clearAll()
}