package com.krishnaAg.CabCompare.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.krishnaAg.CabCompare.data.model.LocationPoint
import com.krishnaAg.CabCompare.data.remote.api.MockCabApiService
import com.krishnaAg.CabCompare.data.repository.CabRepositoryImpl
import com.krishnaAg.CabCompare.domain.usecase.GetFareComparisonUseCase
import com.krishnaAg.CabCompare.ui.screen.home.HomeScreen
import com.krishnaAg.CabCompare.ui.screen.result.ResultScreen
import com.krishnaAg.CabCompare.ui.screen.result.ResultViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("result") {
            // Manual injection for demonstration. 
            // In a real app, use Hilt or Koin for better dependency management.
            val repository = CabRepositoryImpl(MockCabApiService())
            val useCase = GetFareComparisonUseCase(repository)
            
            val viewModel: ResultViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return ResultViewModel(useCase) as T
                    }
                }
            )

            // For demo purposes, we trigger load with dummy points when entering the screen
            LaunchedEffect(Unit) {
                viewModel.loadFares(
                    pickup = LocationPoint(12.9716, 77.5946, "MG Road"),
                    drop = LocationPoint(12.9352, 77.6245, "Koramangala")
                )
            }

            ResultScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onBookClick = { deepLink ->
                    // Handle deep linking to the cab app
                    println("Navigating to: $deepLink")
                }
            )
        }
    }
}
