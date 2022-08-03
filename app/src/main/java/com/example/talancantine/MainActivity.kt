package com.example.talancantine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.talancantine.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationMenuView>(R.id.bottomNavigationView)
        val navController =findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.firstFragmentUser,R.id.secondFragmentUser,R.id.thirdFragmentUser,R.id.fourthFragmentUser))

         setupActionBarWithNavController(navController,appBarConfiguration)


        binding.bottomNavigationView.setupWithNavController(navController)
        }
    }
