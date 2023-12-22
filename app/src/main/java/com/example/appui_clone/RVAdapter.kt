package com.example.appui_clone


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appui_clone.databinding.FragmentHomeBinding
import com.example.appui_clone.databinding.RecyclerviewItemBinding


class RVAdapter(private val streamList: ArrayList<StreamInfo>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val binding: RecyclerviewItemBinding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = streamList.size


    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bind(streamList[position])
    }

    inner class ViewHolder(val binding: RecyclerviewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(streamInfo: StreamInfo) {

            binding.rvTitle.text = streamInfo.title
            binding.rvId.text = streamInfo.id
            binding.rvGameTitle.text = streamInfo.game
            binding.rvThumbnail.setImageResource(streamInfo.thumbnail)
            binding.rvPlayerImage.setBackgroundResource(streamInfo.playerImage)




        }
    }


}


//class RVAdapter(a_list: List<StreamInfo>) :
//    RecyclerView.Adapter<RecyclerViewHolder>() {
//    private val mItemList: List<StreamInfo>
//
//    init {
//        mItemList = a_list
//    }
//
//    override fun onCreateViewHolder(a_viewGroup: ViewGroup, a_viewType: Int): RecyclerViewHolder {
//        val view: View = LayoutInflater.from(a_viewGroup.context)
//            .inflate(R.layout.recyclerview_item, a_viewGroup, false)
//        return RecyclerViewHolder(view)
//    }
//
//    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
//        val item: StreamInfo = mItemList[position]
//        viewHolder.title.setText(item.getTitle())
//        viewHolder.id.setText(item.getId())
//        viewHolder.game.setText(item.getGame())
//        viewHolder.thumbnail.setImageResource(item.getThumbnail())
//        viewHolder.playerImage.setImageResource(item.getPlayerImage())
//
//    }
//
//    override fun getItemCount(): Int {
//        return mItemList.size
//    }
//}