package com.example.aboutfruits.network

import com.example.aboutfruits.model.Fruits
import com.example.aboutfruits.utils.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FruitApiService {
    @GET("all")
   suspend fun getAllFruits(): Response<List<Fruits>>
}

object FruitsApi {
    val retrofitService: FruitApiService by lazy {
        retrofit.create(FruitApiService::class.java)
    }
}
