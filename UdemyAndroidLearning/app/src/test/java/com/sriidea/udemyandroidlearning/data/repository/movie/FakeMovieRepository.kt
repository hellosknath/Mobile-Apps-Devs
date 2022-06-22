package com.sriidea.udemyandroidlearning.data.repository.movie

import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {
    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "OverView1", "path1", "date1", "title1"))
        movies.add(Movie(2, "OverView2", "path2", "date2", "title2"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(5, "OverView5", "path5", "date5", "title5"))
        movies.add(Movie(6, "OverView6", "path6", "date6", "title6"))
        return movies
    }
}