package com.example.retrofit_fetch_data

import com.google.gson.annotations.SerializedName

data class DataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
//    val postName: String,
//    val postMessage: String,
//    val postProfileImgURL: String
)
