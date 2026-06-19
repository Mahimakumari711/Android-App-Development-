package com.example.shoppingapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.data.Product
import com.example.shoppingapp.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductDetailsViewModel : ViewModel() {

    private val repository =
        ProductRepository()

    private val _product =
        MutableStateFlow<Product?>(null)

    val product: StateFlow<Product?> =
        _product

    fun loadProduct(id: Int) {

        viewModelScope.launch {

            _product.value =
                repository.getProductById(id)
        }
    }
}