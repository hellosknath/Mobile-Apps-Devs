package com.sriidea.udemyandroidlearning.data.repository.movies

import android.util.Log
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.model.movie.MovieList
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieLocalDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MovieRemoteDataSource
import com.sriidea.udemyandroidlearning.data.repository.movies.datasource.MoviesCacheDataSource
import com.sriidea.udemyandroidlearning.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val moviesLocalDataSource: MovieLocalDataSource,
    private val moviesCacheDataSource: MoviesCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        moviesLocalDataSource.clearAll()
        moviesLocalDataSource.saveMoviesToDb(newListOfMovies)
        moviesCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (ex: Exception) {
            Log.i("MYTAG", ex.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = moviesLocalDataSource.getMoviesFromDb()
        } catch (ex: Exception) {
            Log.i("MYTAG", ex.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            moviesLocalDataSource.saveMoviesToDb(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = moviesCacheDataSource.getMoviesFromCache()
        } catch (ex: Exception) {
            Log.i("MYTAG", ex.message.toString())
        }

        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDb()
            moviesCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }

}