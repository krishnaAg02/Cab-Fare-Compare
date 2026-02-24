package com.krishnaAg.CabCompare.ui.screen.result


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import com.krishnaAg.CabCompare.ui.components.FareCard

@Composable
fun ResultScreen(viewModel: ResultViewModel) {

    LazyColumn {
        items(viewModel.fares.size) { index ->
            FareCard(viewModel.fares[index])
        }
    }
}
