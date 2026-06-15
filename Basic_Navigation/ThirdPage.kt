package com.example.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ThirdPage(navController: NavController) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("This is Third Page")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Previous")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate("first")
            }
        ) {
            Text("Back To First Page")
        }
    }
}
