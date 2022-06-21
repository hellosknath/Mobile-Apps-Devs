package com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl

import com.sriidea.udemyandroidlearning.data.db.MovieDao
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val moviesDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie>{
        return moviesDao.getAllMovies()
    }


    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.deleteAllMovies()
        }
    }
}