package com.example.aboutfruits

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aboutfruits.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var recyclerAdapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerAdapter = Adapter()
        binding.recyclerView.adapter = recyclerAdapter

        getAllData()

        return binding.root
    }

    private fun getAllData() {
        FruitsApi.retrofitService.getAllFruits().enqueue(object : Callback<List<Fruits>?> {
            override fun onResponse(call: Call<List<Fruits>?>, response: Response<List<Fruits>?>) {
                Log.d("Check123", response.body()!!.toString())
                recyclerAdapter.setFruitListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Fruits>?>, t: Throwable) {
                binding.errorText.text = "Error"
                Log.d("Check123", "Error")
            }
        })
    }
}