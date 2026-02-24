package com.krishnaAg.CabCompare.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.krishnaAg.CabCompare.ui.screen.home.HomeScreen
import com.krishnaAg.CabCompare.ui.screen.result.ResultScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("result") { ResultScreen( ) }
    }
}