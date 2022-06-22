package com.sriidea.udemyandroidlearning.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Database
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.sriidea.udemyandroidlearning.data.model.movie.Movie
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.http.GET

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMoviesTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "OverView1", "path1", "date1", "title1"),
            Movie(2, "OverView2", "path2", "date2", "title2"),
            Movie(3, "OverView3", "path3", "date3", "title3"),
            Movie(4, "OverView4", "path4", "date4", "title4")
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMovieTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "OverView1", "path1", "date1", "title1"),
            Movie(2, "OverView2", "path2", "date2", "title2"),
            Movie(3, "OverView3", "path3", "date3", "title3"),
            Movie(4, "OverView4", "path4", "date4", "title4")
        )
        dao.saveMovies(movies)

        val allMovies = dao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
        dao.deleteAllMovies()
        val allMovie = dao.getMovies()
        Truth.assertThat(allMovie).isEmpty()
    }
}