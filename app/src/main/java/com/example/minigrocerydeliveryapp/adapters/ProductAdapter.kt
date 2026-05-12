package com.example.minigrocerydeliveryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.models.Product

class ProductAdapter(
    private var productList: List<Product>,
    private val onAddToCart: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imgProduct)
        val name = itemView.findViewById<TextView>(R.id.txtProductName)
        val price = itemView.findViewById<TextView>(R.id.txtProductPrice)
        val btnAdd = itemView.findViewById<Button>(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)

        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = productList[position]

        holder.image.setImageResource(product.image)
        holder.name.text = product.name
        holder.price.text = "₹${product.price}"

        holder.btnAdd.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "${product.name} Added To Cart",
                Toast.LENGTH_SHORT
            ).show()
            onAddToCart(product)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun filterList(filteredList: List<Product>) {
        productList = filteredList
        notifyDataSetChanged()
    }
}