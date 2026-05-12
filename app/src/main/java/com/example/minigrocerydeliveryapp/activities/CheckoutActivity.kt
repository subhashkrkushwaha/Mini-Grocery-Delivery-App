package com.example.minigrocerydeliveryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.minigrocerydeliveryapp.R
import kotlin.random.Random

class CheckoutActivity : AppCompatActivity() {
    private lateinit var etAddress: EditText
    private lateinit var rgPayment: RadioGroup
    private lateinit var rbCod: RadioButton
    private lateinit var rbOnline: RadioButton
    private lateinit var btnPlaceOrder: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.checkoutActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()

        btnPlaceOrder.setOnClickListener {
            val address = etAddress.text.toString().trim()
            if (address.isEmpty()) {
                etAddress.error = "Enter delivery address"
                return@setOnClickListener
            }

            val selectedPaymentId = rgPayment.checkedRadioButtonId

            if (selectedPaymentId == -1) {
                Toast.makeText(this, "Select payment option", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val paymentMethod =
                if (rbCod.isChecked) "Cash On Delivery"
                else "Online Payment"

            val orderId = "ORD" + Random.nextInt(1000, 9999)

            val intent = Intent(this, OrderSuccessActivity::class.java)
            intent.putExtra("ORDER_ID", orderId)
            intent.putExtra("ADDRESS", address)
            intent.putExtra("PAYMENT_METHOD", paymentMethod)
            startActivity(intent)
            finish()
        }
    }

    private fun initViews() {
        etAddress = findViewById(R.id.etAddress)
        rgPayment = findViewById(R.id.rgPayment)
        rbCod = findViewById(R.id.rbCod)
        rbOnline = findViewById(R.id.rbOnline)
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder)

    }
}