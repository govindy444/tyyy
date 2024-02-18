package com.example.tyyy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemAdapter(private val items: List<MovieModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_view_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.tv_movie_title.text = currentItem.title
        holder.tvVoteAverage.text = currentItem.description
        Glide.with(context)
            .load("https://www.example.com/image.jpg")
            .into(holder.iv_movie)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView);
        val iv_movie: AppCompatImageView = itemView.findViewById(R.id.iv_movie);
        val tv_movie_title: TextView = itemView.findViewById(R.id.tv_movie_title)
        val tvVoteAverage: TextView = itemView.findViewById(R.id.tvVoteAverage)
    }
}
