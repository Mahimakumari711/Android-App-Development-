package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// import androidx.navigation.compose.*
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "first"
            ) {

                composable("first") {
                    FirstPage(navController)
                }

                composable(
                    route = "second/{name}",
                    arguments = listOf(
                        navArgument("name") {
                            type = NavType.StringType
                        }
                    )
                ) {
                    val name =
                        it.arguments?.getString("name") ?: ""

                    SecondPage(navController, name)
                }

                composable("third") {
                    ThirdPage(navController)
                }
            }
        }
    }
}
