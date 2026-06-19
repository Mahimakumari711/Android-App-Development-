package com.example.shoppingapp.ui.screens.product

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.shoppingapp.viewmodel.ProductDetailsViewModel
import com.example.shoppingapp.viewmodel.CartViewModel

@Composable
fun ProductDetailsScreen(
    productId: Int,
    viewModel: ProductDetailsViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.loadProduct(productId)
    }

    val product by viewModel.product.collectAsState()

    product?.let {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            AsyncImage(
                model = it.image,
                contentDescription = it.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = it.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$${it.price}"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {

                    cartViewModel.addToCart(it)

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add To Cart")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = it.description
            )
        }
    }
}