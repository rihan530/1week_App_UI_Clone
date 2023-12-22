package com.example.appui_clone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appui_clone.databinding.ActivityMainBinding

class NotiFragment : Fragment() {
    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
//        _binding = ActivityMainBinding.inflate(layoutInflater, container, false)

        return inflater.inflate(R.layout.fragment_noti, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() : NotiFragment {

            return NotiFragment()
        }
    }
}