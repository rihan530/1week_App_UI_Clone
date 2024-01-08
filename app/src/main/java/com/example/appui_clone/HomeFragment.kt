package com.example.appui_clone



import android.graphics.drawable.StateListDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appui_clone.databinding.FragmentHomeBinding
import com.google.android.material.navigation.NavigationView


class HomeFragment : Fragment(){

    private var profileButton: ImageButton? = null
    private var drawerLayout: DrawerLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var streamList = ArrayList<StreamInfo>()
    private var streamerList = ArrayList<StreamerInfo>()
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    lateinit var profileFragment: ProfileFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val title = view?.findViewById<TextView>(R.id.rv_title)
        lateinit var navController: NavController
        lateinit var appBarConfiguration: AppBarConfiguration

        streamList.apply {
            add(StreamInfo("수라 2일차", "포셔Portia", "로스트아크", R.drawable.thumbnail_2, R.drawable.profile_2))
            add(StreamInfo("자낳대 과로사팀 탑 연습 2일차", "강소연1", "리그 오브 레전드", R.drawable.thumbnail_3, R.drawable.profile_3))
            add(StreamInfo("전문 스빠룬키 방송 ㅇㅅㅇ;;", "녹두로로", "스펠렁키2", R.drawable.thumbnail_4, R.drawable.profile_4))
            add(StreamInfo("브레이커 육성방송(일단 수라의길)", "이 다", "로스트아크", R.drawable.thumbnail_5, R.drawable.profile_5))
            add(StreamInfo("도현팀 원딜 vs 악어", "따효니 DDaHyoNi", "리그 오브 레전드", R.drawable.thumbnail_6, R.drawable.profile_6))
        }

        streamerList.apply {
            add(StreamerInfo("김도 KimDoe", R.drawable.streamer_profile_1, true))
            add(StreamerInfo("햇살살", R.drawable.streamer_profile_2, true))
            add(StreamerInfo("남궁혁", R.drawable.streamer_profile_3, true))
            add(StreamerInfo("찐자동", R.drawable.streamer_profile_4, false))
            add(StreamerInfo("루 다", R.drawable.streamer_profile_5, false))
            add(StreamerInfo("나는미도", R.drawable.streamer_profile_6, false))
            add(StreamerInfo("린희", R.drawable.streamer_profile_anonymous, false))
            add(StreamerInfo("김나성", R.drawable.streamer_profile_7, false))
            add(StreamerInfo("연두는말안드뤄", R.drawable.streamer_profile_8, false))
            add(StreamerInfo("소니소니쇼", R.drawable.streamer_profile_9, false))
        }

        val rvAdapter = RVAdapter(streamList)
        val rvFollowAdapter = RVFollowAdapter(streamerList)

        _binding!!.list.adapter = rvAdapter

        _binding!!.list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        _binding!!.streamerList.adapter = rvFollowAdapter

        _binding!!.streamerList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val navView: NavigationView? = view?.findViewById(R.id.nav_view)

        val view = binding.root

        binding.ivProfile.setOnClickListener{
            drawerLayout?.closeDrawer(Gravity.RIGHT)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }



}