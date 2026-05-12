# OceanX Agency - Kotlin Android Assignment
## Mini Grocery Delivery App (Blinkit Style)

This project is a simple grocery delivery Android app built in Kotlin using XML layouts, RecyclerView, and a clean MVVM-style structure.

The app allows users to:
- login using mobile number and OTP
- browse products
- search products
- view product categories
- add items to cart
- update quantity
- remove items from cart
- go to checkout
- see order success screen

---

## Project Overview

This app is made as an Android assignment for OceanX Agency.

The main goal of this project is to build a clean, smooth, and easy-to-understand grocery shopping experience similar to a mini Blinkit-style app.

---

## Features Implemented

### 1. Login / OTP Screen
- Mobile number input
- OTP input
- Fake OTP validation
- Navigate to Home Screen after success

### 2. Home Screen
- SearchView for product search
- Category RecyclerView
- Product RecyclerView
- Add to Cart button

### 3. Cart Screen
- Show added items
- Increase quantity
- Decrease quantity
- Remove item
- Show total bill

### 4. Checkout Screen
- Delivery address input
- Payment option selection
- Place order button

### 5. Order Success Screen
- Order ID
- Delivery time
- Order summary
- Success message

---

## Tech Stack

- Kotlin
- XML Layouts
- RecyclerView
- MVVM-style structure
- ViewModel
- LiveData
- Material Design

---

## Important Note

This project is designed for assignment/demo purpose.

### Database
- **Room Database is not used in this version**
- Cart and product data are handled using **temporary in-memory data**
- Data will reset when the app is closed

This was done to keep the project simple and fast to understand for review purposes.

---

## Project Structure

```text
com.example.groceryapp
├── activities
│   ├── LoginActivity
│   ├── HomeActivity
│   ├── CartActivity
│   ├── CheckoutActivity
│   └── OrderSuccessActivity
├── adapters
│   ├── CategoryAdapter
│   ├── ProductAdapter
│   └── CartAdapter
├── model
│   ├── Product
│   ├── Category
│   └── CartItem
├── viewmodel
│   ├── ProductViewModel
│   └── CartViewModel
├── utils
│   ├── Constants
│   ├── Validation
│   └── Extensions
└── res
    ├── layout
    ├── drawable
    └── values
