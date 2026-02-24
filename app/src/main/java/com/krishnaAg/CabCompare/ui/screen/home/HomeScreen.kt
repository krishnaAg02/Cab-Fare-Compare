package com.krishnaAg.CabCompare.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {

    Column {
        Text("Cab Fare Comparison", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = {
            navController.navigate("result")
        }) {
            Text("Compare Prices")
        }
    }
}