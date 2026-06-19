package com.example.shoppingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import com.example.shoppingapp.ui.screens.home.HomeScreen
import com.example.shoppingapp.ui.screens.product.ProductDetailsScreen
import com.example.shoppingapp.ui.screens.cart.CartScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable(
            route = "details/{productId}"
        ) { backStackEntry ->

            val productId =
                backStackEntry.arguments
                    ?.getString("productId")
                    ?.toIntOrNull() ?: 0

            ProductDetailsScreen(
                productId = productId
            )
        }
        composable("cart") {
            CartScreen()
        }
    }
}