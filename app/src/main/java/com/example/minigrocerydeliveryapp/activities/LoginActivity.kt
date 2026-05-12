package com.example.minigrocerydeliveryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.minigrocerydeliveryapp.R

class LoginActivity : AppCompatActivity() {
    private lateinit var etMobile: EditText
    private lateinit var etOtp: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        etMobile = findViewById(R.id.etMobile)
        etOtp = findViewById(R.id.etOtp)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val mobile = etMobile.text.toString().trim()
            val otp = etOtp.text.toString().trim()

            if (mobile.isEmpty()) {
                etMobile.error = "Enter mobile number"
            } else if (mobile.length != 10) {
                etMobile.error = "Enter valid mobile number"
            } else if (otp != "1234") {
                Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }
    }
}