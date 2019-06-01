package com.example.mvvmjsonplaceholder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmjsonplaceholder.R
import com.example.mvvmjsonplaceholder.model.Post
import kotlinx.android.synthetic.main.post_list_item.view.*

class MainActivityAdapter(var postList: List<Post>) : RecyclerView.Adapter<MainActivityAdapter.MainActivityItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityItem {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_list_item, parent, false)

        return MainActivityItem(rootView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MainActivityItem, position: Int) {
        holder.bind(postList[position])
    }

    fun updateList(it: List<Post>) {
        postList = it
        notifyDataSetChanged()
    }


    class MainActivityItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            with(itemView) {
                tv_post.text = post.title
            }
        }
    }

}