package com.example.api_product.network

import com.example.api_product.model.Product
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<Product>
}