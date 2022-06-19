package com.sriidea.udemyandroidlearning.presentation.movies

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sriidea.udemyandroidlearning.R
import com.sriidea.udemyandroidlearning.databinding.ActivityMoviesBinding
import com.sriidea.udemyandroidlearning.presentation.di.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)


        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseMovieListData = movieViewModel.getMovies()
        responseMovieListData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }
}