package com.example.retrofit_fetch_data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofitBuilder: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
//            .baseUrl("https://storage.googleapis.com/network-security-conf-codelab.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}