package com.krishnaAg.CabCompare.data.model

data class FareEstimate(
    val provider: String,
    val cabType: String,
    val price: Double,
    val etaMinutes: Int,
    val deepLink: String
)