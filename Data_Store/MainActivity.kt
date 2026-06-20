package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE)

        setContent {

            var text by remember {
                mutableStateOf(prefs.getString("note", "") ?: "")
            }

            var savedText by remember {
                mutableStateOf(prefs.getString("note", "") ?: "")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Enter text") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        savedText = text

                        prefs.edit()
                            .putString("note", text)
                            .apply()

                        text = ""
                    }
                ) {
                    Text("Save")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = savedText,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
