package com.example.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SecondPage(
    navController: NavController,
    name: String
) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("Hey $name !")

        Text("This is Second Page")

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
                navController.navigate("third")
            }
        ) {
            Text("Next")
        }
    }
}
