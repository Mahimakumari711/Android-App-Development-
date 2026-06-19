package com.example.api_product.model

data class Product(
    val id: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String
)