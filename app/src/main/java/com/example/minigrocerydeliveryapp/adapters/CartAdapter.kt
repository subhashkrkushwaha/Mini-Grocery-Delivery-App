package com.example.minigrocerydeliveryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.models.CartItem

class CartAdapter(
    private val cartList: MutableList<CartItem>,
    private val onIncrease: (CartItem) -> Unit,
    private val onDecrease: (CartItem) -> Unit,
    private val onRemove: (CartItem) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageProduct: ImageView =
            itemView.findViewById(R.id.imgCartProduct)
        val textName: TextView =
            itemView.findViewById(R.id.txtCartProductName)
        val textPrice: TextView =
            itemView.findViewById(R.id.txtCartPrice)
        val textQty: TextView =
            itemView.findViewById(R.id.txtQuantity)
        val btnPlus: Button =
            itemView.findViewById(R.id.btnPlus)
        val btnMinus: Button =
            itemView.findViewById(R.id.btnMinus)
        val btnRemove: Button =
            itemView.findViewById(R.id.btnRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)

        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {

        val cartItem = cartList[position]

        holder.imageProduct.setImageResource(cartItem.product.image)
        holder.textName.text = cartItem.product.name
        holder.textPrice.text = "₹${cartItem.product.price}"
        holder.textQty.text = cartItem.quantity.toString()
        holder.btnPlus.setOnClickListener {
            onIncrease(cartItem)
        }
        holder.btnMinus.setOnClickListener {
            onDecrease(cartItem)
        }
        holder.btnRemove.setOnClickListener {
            onRemove(cartItem)
        }
    }
    override fun getItemCount(): Int {
        return cartList.size
    }
}