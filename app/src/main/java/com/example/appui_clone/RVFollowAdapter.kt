package com.example.appui_clone


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appui_clone.databinding.RecyclerviewFollowItemBinding


class RVFollowAdapter(private val streamerList: ArrayList<StreamerInfo>): RecyclerView.Adapter<RVFollowAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVFollowAdapter.ViewHolder {
        val binding: RecyclerviewFollowItemBinding = RecyclerviewFollowItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = streamerList.size

    override fun onBindViewHolder(holder: RVFollowAdapter.ViewHolder, position: Int) {
        if (streamerList[position].streamStatus) {
            holder.imageBG.setBackgroundResource(R.drawable.image_activate)
        } else {
            holder.imageBG.setBackgroundResource(R.drawable.image_deactivate)
        }
        holder.bind(streamerList[position])
    }

    inner class ViewHolder(val binding: RecyclerviewFollowItemBinding): RecyclerView.ViewHolder(binding.root) {

        val imageBG = binding.rvStreamerBG
        fun bind(streamerInfo: StreamerInfo) {
            binding.rvStreamerName.text = streamerInfo.streamer
            binding.rvStreamerImage.setImageResource(streamerInfo.streamerImage)
        }
    }
}