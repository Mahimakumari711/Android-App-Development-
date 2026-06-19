package com.example.ecommerce.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommerce.navigation.Screen
import com.example.ecommerce.ui.theme.PrimaryPurple
import com.example.ecommerce.components.ProductCard
import com.example.ecommerce.R
import com.example.ecommerce.model.Product

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = PrimaryPurple
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🛍 Ecommerce App",
                    color = androidx.compose.ui.graphics.Color.White,
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Best Deals Everyday",
                    color = androidx.compose.ui.graphics.Color.White
                )
            }

            val products = listOf(
                Product(
                    "iPhone 15",
                    "₹70,000",
                    R.drawable.iphone
                ),
                Product(
                    "Samsung S24",
                    "₹65,000",
                    R.drawable.samsung
                ),
                Product(
                    "Realme 13",
                    "₹18,000",
                    R.drawable.realme
                )
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                products.forEach { product ->

                    ProductCard(
                        name = product.name,
                        price = product.price,
                        imageRes = product.imageRes,
                        onClick = {
                            navController.navigate(Screen.Detail.route)
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate(Screen.Detail.route)
            }
        ) {
            Text("View Product")
        }
    }
}
