package com.example.talancantine

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.talancantine.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homefragment = FirstFragmentUser()
    private val panierfragment= SecondFragmentUser()
    private val favorisfragment= ThirdFragmentUser()
    private val profilefragment= FourthFragmentUser()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homefragment)




        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.firstFragmentUser ->replaceFragment(homefragment)
                R.id.secondFragmentUser ->replaceFragment(panierfragment)
                R.id.thirdFragmentUser ->replaceFragment(favorisfragment)
                R.id.fourthFragmentUser ->replaceFragment(profilefragment)


            }
            true
        }


        }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }

    }

    }
