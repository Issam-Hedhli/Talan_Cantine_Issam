package com.example.talancantine

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.talancantine.databinding.ActivitySignInBinding
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {
    private var mIsShowPass = false

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_sign_in)


        ivShowHidePass.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }

        showPassword(mIsShowPass)


        //admin and admin

        loginbtnSignIn.setOnClickListener {
            //incorrect

            if (usernameSignIn.text.toString() == "") {
                Toast.makeText(this, "USERNAME FAILED", Toast.LENGTH_SHORT).show()

            } else if (passwordSignIn.text.toString() == "") {
                Toast.makeText(this, "PASSWORD FAILED", Toast.LENGTH_SHORT).show()

            }
            //correct

            else if (usernameSignIn.text.toString() == "admin" && passwordSignIn.text.toString() == "admin") {
                Toast.makeText(this, "LOGIN SUCCESSFUL ADMIN", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AdminInterface::class.java))
            } else {
                Toast.makeText(this, "LOGIN SUCCESSFUL USER", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    //password show and hide

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            passwordSignIn.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_visibility_on)
        } else {
            // To hide the password
            passwordSignIn.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePass.setImageResource(R.drawable.ic_visibility_off)
        }
        // This line of code to put the pointer at the end of the password string
        passwordSignIn.setSelection(passwordSignIn.text.toString().length)
    }
}