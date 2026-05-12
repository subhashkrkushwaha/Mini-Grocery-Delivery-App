package com.example.minigrocerydeliveryapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.adapters.CategoryAdapter
import com.example.minigrocerydeliveryapp.adapters.ProductAdapter
import com.example.minigrocerydeliveryapp.models.CartItem
import com.example.minigrocerydeliveryapp.models.Category
import com.example.minigrocerydeliveryapp.models.Product
import java.util.Locale

class HomeActivity : AppCompatActivity() {

    private lateinit var rvCategory: RecyclerView
    private lateinit var rvProducts: RecyclerView
    private lateinit var searchView: SearchView

    private lateinit var productAdapter: ProductAdapter
    private lateinit var cart : ImageView
    private lateinit var switchCompat : SwitchCompat
    private lateinit var productList: ArrayList<Product>
    private val cartList = ArrayList<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.hactivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()

        setupCategoryRecyclerView()

        setupProductRecyclerView()

        setupSearch()
        cart.setOnClickListener {
            val intent = Intent(this,CartActivity::class.java)
            intent.putExtra("cart", cartList)
            startActivity(intent)
        }
        //Mode Dark/Light

        switchCompat.setOnClickListener {
            val mode = AppCompatDelegate.getDefaultNightMode()

            if (mode == AppCompatDelegate.MODE_NIGHT_YES) {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )

            } else {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
                )
            }
        }
    }

    private fun initViews() {
        rvCategory = findViewById(R.id.rvCategory)
        rvProducts = findViewById(R.id.rvProducts)
        searchView = findViewById(R.id.searchView)
        switchCompat = findViewById(R.id.darkMode)
        cart = findViewById(R.id.cart)
    }


    private fun setupCategoryRecyclerView() {
        val categoryList = listOf(
            Category(1, "Fruits", R.drawable.fruits),
            Category(2, "Vegetables", R.drawable.vegetable),
            Category(3, "Milk", R.drawable.milk_bread),
            Category(4, "Snack & Munchies", R.drawable.snack_munchies),
            Category(5, "Sweet Tooth", R.drawable.sweet_tooth),
            Category(6, "Milk & Bread", R.drawable.milk_bread),
            Category(7, "Cold Drink & Juices", R.drawable.cold_drink_juices),
            Category(8, "Oil", R.drawable.oil),
            Category(9, "Pharmacy", R.drawable.pharmacy),
            Category(10, "Fish Meat chicken", R.drawable.fish_meat_chicken)
        )
        rvCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = CategoryAdapter(categoryList)
    }

    private fun setupProductRecyclerView() {
        productList = arrayListOf(
            Product(1, "Apple", 120.0,
                R.drawable.apple, "Fruits"),
            Product(2, "Banana", 60.0,
                R.drawable.banan, "Fruits"),
            Product(3, "Milk", 40.0,
                R.drawable.milk_bread, "Milk"),
            Product(4, "Oil", 40.0,
                R.drawable.oil, "Milk"),
            Product(5, "Tablet", 40.0,
                R.drawable.tablet, "Pharmacy"),
            Product(6, "Fish", 40.0,
                R.drawable.fish, "Fish Meat chicken"),
            Product(7, "Chicken", 40.0,
                R.drawable.fish_meat_chicken, "Fish Meat chicken"),
            Product(8, "Meat", 40.0,
                R.drawable.meat, "Fish Meat chicken"),
            Product(9, "Orange Juices", 20.0,
                R.drawable.orange_j, "Cold Drink & Juices"),
            Product(10, "Chips", 20.0,
                R.drawable.snack_munchies, "Snacks")
        )
//        productAdapter = ProductAdapter(productList)
        productAdapter = ProductAdapter(productList) { product ->
            cartList.add((CartItem (product,1)))
        }
        rvProducts.layoutManager = GridLayoutManager(this,2)
        rvProducts.adapter = productAdapter
    }

    private fun setupSearch() {
        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                filterProducts(newText)
                return true
            }
        })
    }

    private fun filterProducts(query: String?) {
        val filteredList = ArrayList<Product>()
        for (product in productList) {
            if (product.name.lowercase(Locale.getDefault())
                    .contains(query.toString().lowercase(Locale.getDefault()))
            ) {
                filteredList.add(product)
            }
        }
        productAdapter.filterList(filteredList)
    }
}