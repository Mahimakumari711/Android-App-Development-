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
fun ProfileScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "👤 My Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Name: User")

        Text("Orders: 5")

        Text("Settings")

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate(Screen.Home.route)
            }
        ) {
            Text("Back To Home")
        }
    }
}
