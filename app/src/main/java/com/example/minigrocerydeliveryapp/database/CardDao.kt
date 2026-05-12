package com.example.minigrocerydeliveryapp.database


import androidx.lifecycle.LiveData
import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import androidx.room3.Update

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartEntity: CartEntity)

    @Update
    suspend fun updateCartItem(cartEntity: CartEntity)

    @Delete
    suspend fun deleteCartItem(cartEntity: CartEntity)

    @Query("SELECT * FROM cart_table")
    fun getAllCartItems(): LiveData<List<CartEntity>>

    @Query("DELETE FROM cart_table")
    suspend fun clearCart()
}