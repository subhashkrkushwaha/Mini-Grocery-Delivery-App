package com.example.minigrocerydeliveryapp.utils

import android.content.Context
import android.widget.Toast
import android.view.View

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}