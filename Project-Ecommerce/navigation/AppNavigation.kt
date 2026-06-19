package com.example.ecommerce.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.screens.CartScreen
import com.example.ecommerce.screens.DetailScreen
import com.example.ecommerce.screens.HomeScreen
import com.example.ecommerce.screens.ProfileScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Detail.route) {
            DetailScreen(navController)
        }

        composable(Screen.Cart.route) {
            CartScreen(navController)
        }

        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}


