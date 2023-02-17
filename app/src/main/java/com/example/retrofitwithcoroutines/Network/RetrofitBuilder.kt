package com.example.retrofitwithcoroutines.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val url  = "https://jsonplaceholder.typicode.com/"
object RetrofitBuilder {
    //defining lazy so that it creates only whenever it is needed
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : Api by lazy {
        retrofit.create(Api::class.java)
    }
}