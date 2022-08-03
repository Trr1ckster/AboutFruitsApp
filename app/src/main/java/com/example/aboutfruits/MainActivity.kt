package com.example.aboutfruits


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var recyclerView: RecyclerView
lateinit var recyclerAdapter: Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerAdapter = Adapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = recyclerAdapter
        getAllData()
    }

    private fun getAllData() {
        FruitsApi.retrofitService.getAllFruits().enqueue(object : Callback<List<Fruits>?> {
            override fun onResponse(call: Call<List<Fruits>?>, response: Response<List<Fruits>?>) {
                Log.d("Check123", response.body()!!.toString())
                recyclerAdapter.setFruitListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<Fruits>?>, t: Throwable) {
                Log.d("Check123", "Error")
            }
        })
    }

}