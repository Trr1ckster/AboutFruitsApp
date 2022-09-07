package com.example.aboutfruits.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.aboutfruits.databinding.FragmentDetailsBinding
import com.example.aboutfruits.utils.Constants


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.moreButton.setOnClickListener {
            val queryURL: Uri = Uri.parse("${Constants.URL}${viewModel.fruitDetails.value?.name}")
            val intent = Intent(Intent.ACTION_VIEW, queryURL)
            context?.startActivity(intent)
        }

        viewModel.fruitDetails.observe(viewLifecycleOwner) {
           binding.apply {
            name.text = it.name
            genus.text = it.genus
            family.text = it.family
            order.text = it.order
            carbohydrates.text = it.nutritions.carbohydrates.toString()
            protein.text = it.nutritions.protein.toString()
            calories.text = it.nutritions.calories.toString()
            fat.text = it.nutritions.fat.toString()
            sugar.text = it.nutritions.sugar.toString()}
        }
        return binding.root
    }
}