package com.example.minigrocerydeliveryapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minigrocerydeliveryapp.R
import com.example.minigrocerydeliveryapp.models.Category

class CategoryAdapter(
    private val categoryList: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.imgCategory)
        val name = itemView.findViewById<TextView>(R.id.txtCategoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val category = categoryList[position]

        holder.image.setImageResource(category.image)
        holder.name.text = category.name
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}