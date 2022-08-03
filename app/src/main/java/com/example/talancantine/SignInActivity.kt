package com.example.talancantine

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.talancantine.databinding.ActivitySignInBinding
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private var mIsShowPass = false

    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_sign_in)
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password)
        val loginbtn = findViewById<MaterialButton>(R.id.loginbtn)

        ivShowHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }

        showPassword(mIsShowPass)


        //admin and admin

        loginbtn.setOnClickListener {

                if(username.text.toString()=="admin" && password.text.toString()=="admin"){
                    //correct
                    Toast.makeText(this,"LOGIN SUCCESSFUL ADMIN", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,AdminInterface::class.java))
                    }
                else
                    //incorrect
                    Toast.makeText(this,"LOGIN SUCCESSFUL USER",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
            }
    }

    //password show and hide

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_visibility_on)
        } else {
            // To hide the password
            password.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_visibility_off)
        }
        // This line of code to put the pointer at the end of the password string
        password.setSelection(password.text.toString().length)
    }
}