package com.example.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FirstPage(navController: NavController) {

    var name by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text("This is the First Page")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("second/$name")
            }
        ) {
            Text("Next")
        }
    }
}
