package com.example.okhttp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_row_layout.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {
val videoTitle = listOf("First","Second","Thrid")
    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.main_row_layout,parent,false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val videoTitle = homeFeed.videos.get(position)
        holder.itemView.textVdeo_main.text = videoTitle.name
    }



}
class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){

}
