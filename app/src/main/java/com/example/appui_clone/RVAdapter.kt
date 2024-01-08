package com.example.appui_clone


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appui_clone.databinding.RecyclerviewStreamItemBinding


class RVAdapter(private val streamList: ArrayList<StreamInfo>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val binding: RecyclerviewStreamItemBinding = RecyclerviewStreamItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = streamList.size

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bind(streamList[position])
    }

    inner class ViewHolder(val binding: RecyclerviewStreamItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(streamInfo: StreamInfo) {
            binding.rvTitle.text = streamInfo.title
            binding.rvId.text = streamInfo.id
            binding.rvGameTitle.text = streamInfo.game
            binding.rvThumbnail.setImageResource(streamInfo.thumbnail)
            binding.rvPlayerImage.setBackgroundResource(streamInfo.playerImage)
        }
    }
}