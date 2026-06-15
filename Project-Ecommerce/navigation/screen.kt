package com.example.ecommerce.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
}
