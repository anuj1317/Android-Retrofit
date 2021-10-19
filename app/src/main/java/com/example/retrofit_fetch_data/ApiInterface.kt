package com.example.retrofit_fetch_data

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
//@GET("v2/posts.json")
    fun getData(): Call<List<DataItem>>



}