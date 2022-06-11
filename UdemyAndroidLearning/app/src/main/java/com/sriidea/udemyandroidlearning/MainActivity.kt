package com.sriidea.udemyandroidlearning

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sriidea.udemyandroidlearning.databinding.ActivityMainBinding
import com.sriidea.udemyandroidlearning.db.Subscriber
import com.sriidea.udemyandroidlearning.db.SubscriberDao
import com.sriidea.udemyandroidlearning.db.SubscriberDatabase
import com.sriidea.udemyandroidlearning.db.SubscriberRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private lateinit var adapter: MyRecyclerViewAdapter

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

        // all action to inform user through toast message
        subscriberViewModel.message.observe(this, Observer { it ->
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecyclerView() {
        // setting layout manager in recycler view
        binding.lvSubscriber.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(
        ) { selectedItem: Subscriber -> listItemClicked(selectedItem) }
        binding.lvSubscriber.adapter = adapter

        displaySubscriberList()
    }

    private fun displaySubscriberList() {
/*        get all saved data from live data list on view model */
        subscriberViewModel.getSavesSubscribers().observe(this, Observer {
            Log.i(TAG, it.toString())
            adapter.setList(it)
        })
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    // method for list item click
    private fun listItemClicked(subscriber: Subscriber) {
        Toast.makeText(this, "Selected name is ${subscriber.name}", Toast.LENGTH_SHORT).show()
        // calling view model function for update or delete actions
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }
}