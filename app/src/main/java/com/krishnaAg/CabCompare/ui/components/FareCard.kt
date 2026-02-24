package com.krishnaAg.CabCompare.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun FareCard(fare: com.krishnaAg.CabCompare.data.model.FareEstimate) {
    Card {
        Column {
            Text("${fare.provider} - ${fare.cabType}")
            Text("₹${fare.price}")
            Text("ETA: ${fare.etaMinutes} min")
        }
    }
}