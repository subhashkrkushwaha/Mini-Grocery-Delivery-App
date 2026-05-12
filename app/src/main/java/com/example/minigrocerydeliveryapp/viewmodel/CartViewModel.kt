package com.example.minigrocerydeliveryapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minigrocerydeliveryapp.models.CartItem
import com.example.minigrocerydeliveryapp.models.Product

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<MutableList<CartItem>>()

    val cartItems: LiveData<MutableList<CartItem>> = _cartItems

    init {
        _cartItems.value = mutableListOf()
    }

    // ADD ITEM TO CART
    fun addToCart(product: Product) {

        val currentCart = _cartItems.value ?: mutableListOf()

        val existingItem = currentCart.find {
            it.product.id == product.id
        }

        if (existingItem != null) {

            existingItem.quantity++

        } else {

            currentCart.add(
                CartItem(product, 1)
            )
        }

        _cartItems.value = currentCart
    }

    // INCREASE QTY
    fun increaseQuantity(cartItem: CartItem) {

        cartItem.quantity++

        _cartItems.value = _cartItems.value
    }

    // DECREASE QTY
    fun decreaseQuantity(cartItem: CartItem) {

        if (cartItem.quantity > 1) {

            cartItem.quantity--

        } else {

            removeItem(cartItem)
        }

        _cartItems.value = _cartItems.value
    }

    // REMOVE ITEM
    fun removeItem(cartItem: CartItem) {

        val currentCart = _cartItems.value

        currentCart?.remove(cartItem)

        _cartItems.value = currentCart
    }

    // TOTAL PRICE
    fun getTotalPrice(): Double {

        var total = 0.0

        _cartItems.value?.forEach {

            total += it.product.price * it.quantity
        }

        return total
    }

    // TOTAL ITEMS
    fun getTotalItems(): Int {

        var totalItems = 0

        _cartItems.value?.forEach {

            totalItems += it.quantity
        }

        return totalItems
    }

    // CLEAR CART
    fun clearCart() {

        _cartItems.value = mutableListOf()
    }
}