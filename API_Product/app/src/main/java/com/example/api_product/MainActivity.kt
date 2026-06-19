package com.example.api_product

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.api_product.model.Product
import com.example.api_product.network.RetrofitClient
import com.example.api_product.ui.theme.API_ProductTheme
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            API_ProductTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductScreen()
                }
            }
        }
    }
}

@Composable
fun ProductScreen() {

    var products by remember {
        mutableStateOf<List<Product>>(emptyList())
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        try {
            products = RetrofitClient.apiService.getProducts()
            Log.d("API", "Products Loaded: ${products.size}")
        } catch (e: Exception) {
            errorMessage = e.message ?: "Unknown Error"
            Log.e("API", errorMessage)
        }
    }

    if (errorMessage.isNotEmpty()) {

        Text(
            text = "Error: $errorMessage",
            modifier = Modifier.padding(16.dp)
        )

    } else {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {

            items(products) { product ->

                ProductCard(product)

            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = product.title,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Price: $${product.price}"
            )

            Text(
                text = "Category: ${product.category}"
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.description
            )
        }
    }
}