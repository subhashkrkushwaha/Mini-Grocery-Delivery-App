package com.example.minigrocerydeliveryapp.repository


import androidx.lifecycle.LiveData
import com.example.minigrocerydeliveryapp.database.CartDao
import com.example.minigrocerydeliveryapp.database.CartEntity

class CartRepository(private val cartDao: CartDao) {

    val allCartItems: LiveData<List<CartEntity>> =
        cartDao.getAllCartItems()

    suspend fun insertItem(cartEntity: CartEntity) {
        cartDao.insertCartItem(cartEntity)
    }

    suspend fun updateItem(cartEntity: CartEntity) {
        cartDao.updateCartItem(cartEntity)
    }

    suspend fun deleteItem(cartEntity: CartEntity) {
        cartDao.deleteCartItem(cartEntity)
    }

    suspend fun clearCart() {
        cartDao.clearCart()
    }
}