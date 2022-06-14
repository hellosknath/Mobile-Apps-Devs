package com.sriidea.udemyandroidlearning.data.repository.movies.datasourceImpl

import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MoviesCacheDataSource

class MovieCacheDataSourceImpl : MoviesCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}