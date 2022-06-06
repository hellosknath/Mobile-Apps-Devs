package com.sriidea.udemyandroidlearning

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf<Fruits>(
        Fruits("Mango", "Tom"),
        Fruits("Apple", "Joe"),
        Fruits("Banana", "Moe"),
        Fruits("Guava", "Toe"),
        Fruits("Lemon", "ALex"),
        Fruits("Pear", "Sri"),
        Fruits("Orange", "Jak")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.setBackgroundColor(Color.BLACK)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList)
    }
}