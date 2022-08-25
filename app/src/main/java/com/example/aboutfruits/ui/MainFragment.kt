package com.example.aboutfruits.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutfruits.adapter.Adapter
import com.example.aboutfruits.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var recyclerAdapter: Adapter

    private val viewModel: FruitsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerAdapter = Adapter()
        binding.recyclerView.adapter = recyclerAdapter

        viewModel.fruitsLiveData.observe(viewLifecycleOwner) {
            recyclerAdapter.setFruitListItems(it)
        }

        return binding.root
    }
}