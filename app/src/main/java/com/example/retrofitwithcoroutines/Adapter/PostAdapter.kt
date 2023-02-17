package com.example.retrofitwithcoroutines.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofitwithcoroutines.Model.Post
import com.example.retrofitwithcoroutines.R

class PostAdapter (val context : Context, var postList : ArrayList<Post>): RecyclerView.Adapter<PostAdapter.PostViewHolder>()
{
    class PostViewHolder(itemView: View) : ViewHolder(itemView){
        val id : TextView = itemView.findViewById(R.id.id)
        val title  : TextView = itemView.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.each_row,parent,false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.id.text = post.id.toString()
        holder.title.text = post.title.toString()
    }

    fun setData( postList : ArrayList<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }
}