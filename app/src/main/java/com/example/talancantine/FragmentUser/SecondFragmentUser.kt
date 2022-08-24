package com.example.talancantine.FragmentUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.R
import com.example.talancantine.adapter.CartAdapter
import com.example.talancantine.databinding.FragmentSecondUserBinding
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_second_user.*
import kotlinx.android.synthetic.main.item_rv_cart.*


class SecondFragmentUser : Fragment() {
    private lateinit var _binding: FragmentSecondUserBinding
    private val binding get() = _binding

    private var adapterCart: CartAdapter?= null
    private var linearLayoutManagerCart: RecyclerView.LayoutManager?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding= FragmentSecondUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManagerCart= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_cart.layoutManager=linearLayoutManagerCart

        adapterCart= CartAdapter()
        rv_cart.adapter=adapterCart
    }

}


