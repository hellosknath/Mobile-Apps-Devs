package com.sriidea.udemyandroidlearning.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import com.sriidea.udemyandroidlearning.data.repository.movie.FakeMovieRepository
import com.sriidea.udemyandroidlearning.domain.usecase.GetMoviesUseCase
import com.sriidea.udemyandroidlearning.domain.usecase.UpdateMoviesUsecase
import com.sriidea.udemyandroidlearning.getOrAwaitValue

import org.junit.Before
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUsecase(fakeMovieRepository)
        movieViewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "OverView1", "path1", "date1", "title1"))
        movies.add(Movie(2, "OverView2", "path2", "date2", "title2"))

        val currentList = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun getUpdateMovies_returnUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(5, "OverView5", "path5", "date5", "title5"))
        movies.add(Movie(6, "OverView6", "path6", "date6", "title6"))

        val updatedList = movieViewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(updatedList).isEqualTo(movies)
    }
}