package com.example.aboutfruits.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aboutfruits.model.Fruits
import com.example.aboutfruits.network.FruitsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitsViewModel : ViewModel() {

    private val _fruitsLiveData: MutableLiveData<List<Fruits>> = MutableLiveData()
    val fruitsLiveData: LiveData<List<Fruits>> = _fruitsLiveData

    init {
        getAllData()
    }

    private fun getAllData() {
        FruitsApi.retrofitService.getAllFruits().enqueue(object : Callback<List<Fruits>?> {
            override fun onResponse(call: Call<List<Fruits>?>, response: Response<List<Fruits>?>) {
                _fruitsLiveData.value = response.body()
                Log.d("Check123", response.body().toString())

            }

            override fun onFailure(call: Call<List<Fruits>?>, t: Throwable) {
                Log.d("Check123", "$t")
            }
        })
    }
}

