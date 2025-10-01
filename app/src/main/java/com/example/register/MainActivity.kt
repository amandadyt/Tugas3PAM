package com.example.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.register.screen.DaftarScreen
import com.example.register.screen.DetailScreen
import com.example.register.screen.LoginScreen
import com.example.register.ui.theme.RegisterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("daftar") {
            DaftarScreen(navController)
        }

        composable("detail/{nim}/{nama}/{email}") { backStackEntry ->
            DetailScreen(
                navController,
                nim = backStackEntry.arguments?.getString("nim"),
                nama = backStackEntry.arguments?.getString("nama"),
                email = backStackEntry.arguments?.getString("email")
            )
        }
    }
}