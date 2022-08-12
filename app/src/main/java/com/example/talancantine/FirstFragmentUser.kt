package com.example.talancantine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talancantine.adapter.RecyclerAdapterCategory
import com.example.talancantine.adapter.RecyclerAdapterMenus
import com.example.talancantine.databinding.FragmentFirstUserBinding
import kotlinx.android.synthetic.main.fragment_first_user.*
import kotlinx.android.synthetic.main.item_rv_main_menus.*


class FirstFragmentUser : Fragment() {
    private var _binding: FragmentFirstUserBinding? = null
    private val binding get() = _binding!!

    private var adapterCategory : RecyclerAdapterCategory?= null
    private var linearLayoutManagerCategory:RecyclerView.LayoutManager?=null

    private var adapterMenus:RecyclerAdapterMenus?=null
    private var linearLayoutManagerMenus:RecyclerView.LayoutManager?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

          _binding= FragmentFirstUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView main category
        linearLayoutManagerCategory=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
        rv_main_category.layoutManager=linearLayoutManagerCategory

        adapterCategory= RecyclerAdapterCategory()
        rv_main_category.adapter=adapterCategory

        //recyclerView main_menus
        linearLayoutManagerMenus=LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false)
        rv_main_menus.layoutManager=linearLayoutManagerMenus

        adapterMenus= RecyclerAdapterMenus()
        rv_main_menus.adapter=adapterMenus



    }

}



