package com.example.shoppingapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.CartItem
import com.example.shoppingapp.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {

    private val _cartItems =
        MutableStateFlow<List<CartItem>>(emptyList())

    val cartItems: StateFlow<List<CartItem>>
            = _cartItems

    fun addToCart(product: Product) {

        val currentItems =
            _cartItems.value.toMutableList()

        val existingItem =
            currentItems.find {
                it.product.id == product.id
            }

        if (existingItem != null) {

            existingItem.quantity++

        } else {

            currentItems.add(
                CartItem(product)
            )
        }

        _cartItems.value = currentItems
    }

    fun removeFromCart(productId: Int) {

        _cartItems.value =
            _cartItems.value.filter {
                it.product.id != productId
            }
    }

    fun getTotalPrice(): Double {

        return _cartItems.value.sumOf {

            it.product.price * it.quantity
        }
    }
}