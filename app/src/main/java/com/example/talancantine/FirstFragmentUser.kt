package com.example.talancantine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.databinding.FragmentFirstUserBinding
import kotlinx.android.synthetic.main.fragment_first_user.*


class FirstFragmentUser : Fragment() {
    private var _binding: FragmentFirstUserBinding? = null
    private val binding get() = _binding!!
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

          _binding= FragmentFirstUserBinding.inflate(inflater, container, false)
        rv_main_category.adapter=adapter
        return binding.root
    }


}



