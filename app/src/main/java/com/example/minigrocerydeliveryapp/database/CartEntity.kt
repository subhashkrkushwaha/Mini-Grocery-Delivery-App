package com.example.minigrocerydeliveryapp.database


import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(tableName = "cart_table")
data class CartEntity(

    @PrimaryKey
    val id: Int,

    val name: String,

    val price: Double,

    val image: Int,

    var quantity: Int
)