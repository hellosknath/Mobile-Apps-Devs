package com.sriidea.udemyandroidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sriidea.udemyandroidlearning.databinding.ActivityMainBinding
import com.sriidea.udemyandroidlearning.db.SubscriberDao
import com.sriidea.udemyandroidlearning.db.SubscriberDatabase
import com.sriidea.udemyandroidlearning.db.SubscriberRepository
import kotlinx.coroutines.flow.observeOn

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao: SubscriberDao = SubscriberDatabase.getInstance(application).subscriberDao
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory)[SubscriberViewModel::class.java]
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.lvSubscriber.layoutManager = LinearLayoutManager(this)
        displaySubscriberList()
    }

    private fun displaySubscriberList() {
        subscriberViewModel.getSavesSubscribers().observe(this, Observer {
            Log.i(TAG, it.toString())
            binding.lvSubscriber.adapter = MyRecyclerViewAdapter(it)
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}