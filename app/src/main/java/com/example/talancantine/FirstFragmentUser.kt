package com.example.talancantine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.talancantine.databinding.FragmentFirstUserBinding


class FirstFragmentUser : Fragment() {
    private var _binding: FragmentFirstUserBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

          _binding= FragmentFirstUserBinding.inflate(inflater, container, false)
        return binding.root
    }
}



