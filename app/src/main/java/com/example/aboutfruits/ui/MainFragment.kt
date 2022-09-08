package com.example.aboutfruits.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aboutfruits.R
import com.example.aboutfruits.adapter.Adapter
import com.example.aboutfruits.adapter.ClickListener
import com.example.aboutfruits.databinding.FragmentMainBinding
import com.example.aboutfruits.utils.Status

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var recyclerAdapter: Adapter

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerAdapter = Adapter(ClickListener { fruit ->
            viewModel.onItemClicked(fruit)
            findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
        })
        binding.recyclerView.adapter = recyclerAdapter

        viewModel.fruitsLiveData.observe(viewLifecycleOwner) {
            recyclerAdapter.setFruitListItems(it)
        }

        viewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.noConnection.visibility = View.VISIBLE
                }
            }

        }

        return binding.root
    }
}