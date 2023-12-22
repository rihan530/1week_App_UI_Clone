package com.example.appui_clone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class StreamListAdapter(private val context: Context, private val streamList: ArrayList<StreamInfo>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val lv_thumbnail = view.findViewById<ImageView>(R.id.lv_thumbnail)
        val lv_playerImage = view.findViewById<ImageView>(R.id.lv_playerImage)
        val lv_title = view.findViewById<TextView>(R.id.lv_title)
        val lv_id = view.findViewById<TextView>(R.id.lv_ID)
        val lv_gameTitle = view.findViewById<TextView>(R.id.lv_gameTitle)

        /* ArrayList<Dog>의 변수 dog의 이미지와 데이터를 ImageView와 TextView에 담는다. */
//        val stream = streamList[position]
//        val resourceId1 = context.resources.getIdentifier(stream.thumbnail, "drawable", context.packageName)
//        val resourceId2 = context.resources.getIdentifier(stream.playerImage, "drawable", context.packageName)
//        lv_thumbnail.setImageResource(resourceId1)
//        lv_playerImage.setImageResource(resourceId2)
//        lv_title.text = stream.title
//        lv_id.text = stream.id
//        lv_gameTitle.text = stream.game

        return view
    }

    override fun getItem(position: Int): Any {
        return streamList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return streamList.size
    }
}