package com.example.appui_clone



import android.view.View

import android.widget.ImageView

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView
    var id: TextView
    var game: TextView
    var thumbnail: ImageView
    var playerImage: ImageView

    init {
        title = itemView.findViewById<TextView>(R.id.rv_title)
        id = itemView.findViewById<TextView>(R.id.rv_id)
        game = itemView.findViewById<TextView>(R.id.rv_gameTitle)
        thumbnail = itemView.findViewById<ImageView>(R.id.rv_thumbnail)
        playerImage = itemView.findViewById<ImageView>(R.id.rv_playerImage)
    }
}