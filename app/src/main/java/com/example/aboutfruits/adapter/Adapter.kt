package com.example.aboutfruits.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutfruits.R
import com.example.aboutfruits.model.Fruits

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var fruitList = listOf<Fruits>()

    fun setFruitListItems(fruitList: List<Fruits>) {
        this.fruitList = fruitList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val family: TextView = view.findViewById(R.id.family)
        val genus: TextView = view.findViewById(R.id.genus)
        val order: TextView = view.findViewById(R.id.order)
        val carbohydrates: TextView = view.findViewById(R.id.carbohydrates)
        val protein: TextView = view.findViewById(R.id.protein)
        val fat: TextView = view.findViewById(R.id.fat)
        val calories: TextView = view.findViewById(R.id.calories)
        val sugar: TextView = view.findViewById(R.id.sugar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = "Name: " + fruitList[position].name
        holder.family.text = "Family: " + fruitList[position].family
        holder.genus.text = "Genus: " + fruitList[position].genus
        holder.order.text = "Order: " + fruitList[position].order
        holder.carbohydrates.text =
            "Carbohydrates: " + fruitList[position].nutritions.carbohydrates.toString()
        holder.protein.text = "Protein: " + fruitList[position].nutritions.carbohydrates.toString()
        holder.fat.text = "Fat: " + fruitList[position].nutritions.fat.toString()
        holder.calories.text = "Calories: " + fruitList[position].nutritions.calories.toString()
        holder.sugar.text = "Sugar: " + fruitList[position].nutritions.sugar.toString()

    }

    override fun getItemCount() = fruitList.size
}