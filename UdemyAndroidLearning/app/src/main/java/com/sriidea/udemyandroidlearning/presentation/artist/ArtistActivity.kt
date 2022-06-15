package com.sriidea.udemyandroidlearning.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sriidea.udemyandroidlearning.R
import com.sriidea.udemyandroidlearning.databinding.ActivityArtistBinding
import com.sriidea.udemyandroidlearning.databinding.ActivityTvshowBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
    }
}