package com.sriidea.udemyandroidlearning.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sriidea.udemyandroidlearning.R
import com.sriidea.udemyandroidlearning.databinding.ActivityMoviesBinding
import com.sriidea.udemyandroidlearning.presentation.di.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)


        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]

        val responseMovieListData = movieViewModel.getMovies()
        responseMovieListData.observe(this, Observer {
            Log.i("MYTAG", it.toString())
        })

    }
}