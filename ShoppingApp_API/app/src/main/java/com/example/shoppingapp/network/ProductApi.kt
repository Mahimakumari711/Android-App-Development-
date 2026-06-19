package com.example.shoppingapp.network

import com.example.shoppingapp.data.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>

    @GET("products/{id}")
    suspend fun getProductById(
        @retrofit2.http.Path("id") id: Int
    ): Product
}

