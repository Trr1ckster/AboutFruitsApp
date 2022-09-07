package com.example.aboutfruits.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aboutfruits.model.Fruits
import com.example.aboutfruits.network.FruitsApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _fruitsLiveData: MutableLiveData<List<Fruits>> = MutableLiveData()
    val fruitsLiveData: LiveData<List<Fruits>> = _fruitsLiveData

    private val _fruitDetails: MutableLiveData<Fruits> = MutableLiveData()
    val fruitDetails: LiveData<Fruits> = _fruitDetails

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        try {
            _fruitsLiveData.value = FruitsApi.retrofitService.getAllFruits().body()
        } catch (e: Exception) {
            Log.d("Check123", "$e")
        }
    }

    fun onItemClicked(fruits: Fruits) {
        _fruitDetails.value = fruits
    }

}
