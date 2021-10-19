package com.example.retrofit_fetch_data

import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
//    var dataList = ArrayList<DataItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rv_list)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager


//        myAdapter = MyAdapter(baseContext,dataList)
//        recyclerView.adapter = myAdapter


        getMyData()
    }

    private fun getMyData() {


        val retrofitData = RetrofitInstance.retrofitBuilder.getData()
        //Ctrl+shift+space to get the callbacks
        retrofitData.enqueue(object : Callback<List<DataItem>?> {
            override fun onResponse(
                call: Call<List<DataItem>?>,
                response: Response<List<DataItem>?>
            ) {
              val responsebody= response.body()!!
                myAdapter = MyAdapter(baseContext,responsebody)
                recyclerView.adapter = myAdapter
//                dataList.addAll(responsebody?.posts)


                myAdapter.notifyDataSetChanged()


            }

            override fun onFailure(call: Call<List<DataItem>?>, t: Throwable) {
              Log.d("MainActivity","onFailure:" + t.message)
            }
        })

    }
}