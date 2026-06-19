package com.example.shoppingapp.repository

import com.example.shoppingapp.network.RetrofitClient
import com.example.shoppingapp.data.Product

class ProductRepository {

    suspend fun getProducts() =
        RetrofitClient.api.getProducts()

    suspend fun getProductById(
        id: Int
    ): Product {

        return RetrofitClient.api
            .getProductById(id)
    }
}

