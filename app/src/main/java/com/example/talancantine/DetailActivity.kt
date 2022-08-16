package com.example.talancantine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var numberOrder = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getBundle()

    }

    private fun getBundle() {
        numberOrderTxt.setText(""+numberOrder)

        plus.setOnClickListener {
            numberOrderTxt.setText("" + ++numberOrder)
        }

        minus.setOnClickListener {
            if (numberOrder > 1) {
                numberOrderTxt.setText("" + --numberOrder)
            }
        }
    }
}
