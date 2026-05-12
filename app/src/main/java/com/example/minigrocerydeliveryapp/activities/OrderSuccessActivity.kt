package com.example.minigrocerydeliveryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.minigrocerydeliveryapp.R

class OrderSuccessActivity : AppCompatActivity() {
    private lateinit var tvOrderId: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvPayment: TextView
    private lateinit var tvDeliveryTime: TextView
    private lateinit var btnBackHome: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_success)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.orderSuccess)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()

        val orderId = intent.getStringExtra("ORDER_ID")
        val address = intent.getStringExtra("ADDRESS")
        val payment = intent.getStringExtra("PAYMENT_METHOD")

        tvOrderId.text = "Order ID : $orderId"
        tvAddress.text = "Delivery Address : $address"
        tvPayment.text = "Payment Method : $payment"
        tvDeliveryTime.text = "Estimated Delivery : 20 - 30 mins"
        btnBackHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish();

        }
    }

    private fun initViews() {
        tvOrderId = findViewById(R.id.tvOrderId)
        tvAddress = findViewById(R.id.tvAddress)
        tvPayment = findViewById(R.id.tvPayment)
        tvDeliveryTime = findViewById(R.id.tvDeliveryTime)
        btnBackHome = findViewById(R.id.btnBackHome)
    }
}