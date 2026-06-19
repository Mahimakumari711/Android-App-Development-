package com.example.shoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shoppingapp.ui.screens.home.HomeScreen
import com.example.shoppingapp.ui.theme.ShoppingAppTheme
import com.example.shoppingapp.navigation.AppNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            ShoppingAppTheme {

                AppNavigation()

            }
        }
    }
}