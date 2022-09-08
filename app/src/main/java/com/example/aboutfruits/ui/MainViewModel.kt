package com.example.aboutfruits.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aboutfruits.model.Fruits
import com.example.aboutfruits.network.FruitsApi
import com.example.aboutfruits.utils.Status
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _fruitsLiveData: MutableLiveData<List<Fruits>> = MutableLiveData()
    val fruitsLiveData: LiveData<List<Fruits>> = _fruitsLiveData

    private val _fruitDetails: MutableLiveData<Fruits> = MutableLiveData()
    val fruitDetails: LiveData<Fruits> = _fruitDetails

    val status = MutableLiveData<Status>()

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        status.postValue(Status.LOADING)
        try {
            _fruitsLiveData.value = FruitsApi.retrofitService.getAllFruits().body()
            status.postValue(Status.SUCCESS)
        } catch (e: Exception) {
            status.postValue(Status.ERROR)
        }
    }

    fun onItemClicked(fruits: Fruits) {
        _fruitDetails.value = fruits
    }

}
