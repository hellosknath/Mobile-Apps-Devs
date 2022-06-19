package com.sriidea.udemyandroidlearning.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sriidea.udemyandroidlearning.R
import com.sriidea.udemyandroidlearning.databinding.ActivityHomeBinding
import com.sriidea.udemyandroidlearning.presentation.artist.ArtistActivity
import com.sriidea.udemyandroidlearning.presentation.movies.MoviesActivity
import com.sriidea.udemyandroidlearning.presentation.tv.TVShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }
        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TVShowActivity::class.java)
            startActivity(intent)
        }
    }
}