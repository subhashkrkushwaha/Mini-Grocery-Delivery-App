package com.example.minigrocerydeliveryapp.dummyData

import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.models.Product

val productList = listOf(

    Product(
        id = 1,
        name = "Apple",
        price = 120.0,
        image = R.drawable.ic_cart,
        category = "Fruits"
    ),

    Product(
        id = 2,
        name = "Milk",
        price = 60.0,
        image = R.drawable.ic_cart,
        category = "Dairy"
    ),

    Product(
        id = 3,
        name = "Bread",
        price = 40.0,
        image = R.drawable.ic_cart,
        category = "Bakery"
    )
)