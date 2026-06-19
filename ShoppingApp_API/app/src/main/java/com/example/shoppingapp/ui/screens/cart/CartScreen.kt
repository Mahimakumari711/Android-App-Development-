package com.example.shoppingapp.ui.screens.cart

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppingapp.viewmodel.CartViewModel

@Composable
fun CartScreen(
    cartViewModel: CartViewModel = viewModel()
) {

    val cartItems by
    cartViewModel.cartItems.collectAsState()

    LazyColumn {

        items(cartItems) { item ->

            Text(
                "${item.product.title} x${item.quantity}"
            )
        }
    }
}