package com.sriidea.udemyandroidlearning.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sriidea.udemyandroidlearning.R
import com.sriidea.udemyandroidlearning.databinding.ActivityTvshowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvshowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tvshow)
    }
}