package com.example.retrofit_fetch_data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context :Context, val userlist: List<DataItem>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var userId: TextView
        var title: TextView
//        var imageView:ImageView

        init {
            userId = itemView.findViewById(R.id.tv_userid)
            title = itemView.findViewById(R.id.tv_title)
//            imageView = itemView.findViewById(R.id.iv_imageView)

        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return userlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = userlist[position].userId.toString()
        holder.title.text = userlist[position].title
//        val profileImgURL = userlist[position].postProfileImgURL
//        Glide.with(context).load(profileImgURL).placeholder(R.drawable.ic_launcher_foreground)
//            .into(holder.imageView)

    }
}