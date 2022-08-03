package com.example.aboutfruits

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


private const val BASE_URL = "https://www.fruityvice.com/api/fruit/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FruitApiService {
    @GET("all")
    fun getAllFruits(): Call<List<Fruits>>
}


object FruitsApi {
    val retrofitService: FruitApiService = retrofit.create(FruitApiService::class.java)
}