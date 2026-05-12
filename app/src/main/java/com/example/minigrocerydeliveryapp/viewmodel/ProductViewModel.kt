package com.example.minigrocerydeliveryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.models.Product

class ProductViewModel : ViewModel() {

    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>> = _productList

    private val allProducts = mutableListOf<Product>()

    init {
        loadProducts()
    }

    private fun loadProducts() {

        val products = listOf(

            Product(
                id = 1,
                name = "Apple",
                price = 120.0,
                image = R.drawable.ic_home,
                category = "Fruits"),

            Product(
                id = 2,
                name = "Banana",
                price = 60.0,
                image = R.drawable.ic_home,
                category = "Fruits"),

            Product(
                id = 3,
                name = "Milk",
                price = 50.0,
                image = R.drawable.ic_home,
                category = "Dairy"),

            Product(
                id = 4,
                name = "Bread",
                price = 40.0,
                image = R.drawable.ic_home,
                category = "Bakery"
            ),

            Product(
                id = 5,
                name = "Cold Drink",
                price = 90.0,
                image = R.drawable.ic_home,
                category = "Drinks"
            )
        )

        allProducts.addAll(products)

        _productList.value = allProducts
    }

    fun searchProducts(query: String) {

        if (query.isEmpty()) {
            _productList.value = allProducts
            return
        }

        val filteredList = allProducts.filter {

            it.name.contains(query, ignoreCase = true)
        }

        _productList.value = filteredList
    }
}