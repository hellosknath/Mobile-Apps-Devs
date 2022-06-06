package com.sriidea.udemyandroidlearning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitsList: List<Fruits>,
    private val clickListener: (Fruits) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        holder.bind(fruit, clickListener)
    }

    override fun getItemCount(): Int {
        return fruitsList.size
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruits: Fruits, clickListener: (Fruits) -> Unit) {
        val nameText = view.findViewById<TextView>(R.id.nameText)
        nameText.text = fruits.name
        view.setOnClickListener {
            clickListener(fruits)
        }
    }

}