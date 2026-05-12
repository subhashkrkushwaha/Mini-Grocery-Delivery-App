package com.example.minigrocerydeliveryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.adapters.CartAdapter
import com.example.minigrocerydeliveryapp.models.CartItem

class CartActivity : AppCompatActivity() {
    private lateinit var rvCart: RecyclerView
    private lateinit var tvTotal: TextView
    private lateinit var btnCheckout: Button
    private lateinit var cartList: ArrayList<CartItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cardActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvCart = findViewById(R.id.rvCart)
        tvTotal = findViewById(R.id.tvTotal)
        btnCheckout = findViewById(R.id.btnCheckout)

        cartList = intent.getSerializableExtra("cart") as ArrayList<CartItem>
        val adapter = CartAdapter(
            cartList,
            onIncrease = {
                it.quantity++
                updateTotal()
                rvCart.adapter?.notifyDataSetChanged()
            },
            onDecrease = {
                if (it.quantity > 1) {
                    it.quantity--
                    updateTotal()
                    rvCart.adapter?.notifyDataSetChanged()
                }
            },

            onRemove = {
                cartList.remove(it)
                updateTotal()
                rvCart.adapter?.notifyDataSetChanged()
            })

        rvCart.layoutManager = LinearLayoutManager(this)
        rvCart.adapter = adapter
        updateTotal()

        btnCheckout.setOnClickListener {
            val total = calculateTotal()
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
        }
    }

    private fun calculateTotal(): Int {
        var total = 0
        for (item in cartList) {
            total += (item.product.price * item.quantity).toInt()
        }
        return total
    }

    private fun updateTotal() {
        tvTotal.text = "Total : ₹${calculateTotal()}"
    }
}