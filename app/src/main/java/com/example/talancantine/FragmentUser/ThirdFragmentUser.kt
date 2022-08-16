package com.example.talancantine.FragmentUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.talancantine.databinding.FragmentThirdUserBinding


class ThirdFragmentUser : Fragment() {

    private var _binding: FragmentThirdUserBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdUserBinding.inflate(inflater, container, false)
        return binding.root
    }



}


