package com.example.ecommerce.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecommerce.navigation.Screen

@Composable
fun DetailScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "📱 iPhone 15",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Price: ₹70,000")

        Spacer(modifier = Modifier.height(8.dp))

        Text("Latest Apple Smartphone")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate(Screen.Cart.route)
            }
        ) {
            Text("Add To Cart")
        }
    }
}
