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
import android.util.Patterns
import android.view.MotionEvent
import android.view.View


class SignUpActivity : AppCompatActivity() {
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

        //password show and hide




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
    }