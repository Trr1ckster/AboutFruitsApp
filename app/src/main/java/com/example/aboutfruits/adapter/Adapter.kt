package com.example.aboutfruits.adapter

import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutfruits.R
import com.example.aboutfruits.databinding.FruitItemBinding
import com.example.aboutfruits.model.Fruits

class Adapter(private val onItemClick: ClickListener) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var fruitList = listOf<Fruits>()

    fun setFruitListItems(fruitList: List<Fruits>) {
        this.fruitList = fruitList
        differ.submitList(fruitList)
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Fruits>() {
        override fun areItemsTheSame(oldItem: Fruits, newItem: Fruits): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Fruits, newItem: Fruits): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    class ViewHolder(binding: FruitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(FruitItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = fruitList[position].name
        holder.itemView.setOnClickListener {
            onItemClick.onClick(fruitList[position])
        }
    }

    override fun getItemCount() = differ.currentList.size
}

class ClickListener(val clickListener: (fruit: Fruits) -> Unit) {
    fun onClick(fruit: Fruits) = clickListener(fruit)
}