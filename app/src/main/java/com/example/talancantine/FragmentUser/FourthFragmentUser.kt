package com.example.talancantine.FragmentUser

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.talancantine.Homepage
import com.example.talancantine.R
import com.example.talancantine.SignInActivity
import kotlinx.android.synthetic.main.fragment_fourth_user.*


class FourthFragmentUser : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ll_deconnexion.setOnClickListener {
            Handler().postDelayed({
                val intent=Intent(context, SignInActivity::class.java)
                startActivity(intent)
            },2000)        }


    }

}