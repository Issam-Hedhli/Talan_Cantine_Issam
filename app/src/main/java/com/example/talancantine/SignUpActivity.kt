package com.example.talancantine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.talancantine.databinding.ActivitySignInBinding
import com.example.talancantine.databinding.ActivitySignUpBinding
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_sign_up.*
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignUpActivity : AppCompatActivity() {
    private var mIsShowPass = false

    private lateinit var binding:ActivitySignUpBinding
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = findViewById<TextView>(R.id.username)
        val email = findViewById<TextView>(R.id.email)
        val password = findViewById<TextView>(R.id.password)
        val registerbtn = findViewById<MaterialButton>(R.id.registerbtn)


        ivShowHidePassSignUp.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }

        showPassword(mIsShowPass)

        ivShowHidePassConfirm.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showConfirmPassword(mIsShowPass)
        }

        showConfirmPassword(mIsShowPass)


        registerbtn.setOnClickListener {

            if(username.text.toString()!="" &&
                isValidEmail(email.text.toString()) &&
                password.text.toString()!="" &&
                password_confirm.text.toString()==password.text.toString()

            ){
                //correct
                Toast.makeText(this,"ACCOUNT CREATED", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,SignInActivity::class.java))
            }
            else
                //incorrect
                Toast.makeText(this,"FAILED!!!", Toast.LENGTH_SHORT).show()
        }
    }

    //show and hide password
    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            passwordSignUp.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePassSignUp.setImageResource(R.drawable.ic_visibility_on)
        } else {
            // To hide the password
            passwordSignUp.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePassSignUp.setImageResource(R.drawable.ic_visibility_off)
        }
        // This line of code to put the pointer at the end of the password string
        passwordSignUp.setSelection(passwordSignUp.text.toString().length)
    }
    //show and hide confirm password
    private fun showConfirmPassword(isShow: Boolean) {
        if (isShow) {
            // To show the password
            password_confirm.transformationMethod = HideReturnsTransformationMethod.getInstance()
            ivShowHidePassConfirm.setImageResource(R.drawable.ic_visibility_on)
        } else {
            // To hide the password
            password_confirm.transformationMethod = PasswordTransformationMethod.getInstance()
            ivShowHidePassConfirm.setImageResource(R.drawable.ic_visibility_off)
        }
        // This line of code to put the pointer at the end of the password string
        password_confirm.setSelection(password_confirm.text.toString().length)
    }
    }