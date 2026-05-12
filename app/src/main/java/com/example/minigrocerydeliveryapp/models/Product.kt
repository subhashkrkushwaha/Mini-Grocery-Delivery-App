package com.example.minigrocerydeliveryapp.models

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val image: Int,
    val category: String,
    var quantity: Int = 1
) : Serializable