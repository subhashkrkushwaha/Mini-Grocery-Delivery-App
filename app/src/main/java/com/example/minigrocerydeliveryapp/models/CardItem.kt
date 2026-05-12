package com.example.minigrocerydeliveryapp.models

import java.io.Serializable

data class CartItem(
    val product: Product,
    var quantity: Int
) : Serializable {
    fun getTotalPrice(): Double {
        return product.price * quantity
    }
}