package com.sriidea.udemyandroidlearning.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sriidea.udemyandroidlearning.R
import com.sriidea.udemyandroidlearning.databinding.ActivityMoviesBinding

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)
    }
}