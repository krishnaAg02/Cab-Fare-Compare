package com.krishnaAg.CabCompare.data.remote.api

import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint


interface CabApiService {
    suspend fun fetchFareEstimates(
        pickup: LocationPoint,
        drop: LocationPoint
    ): List<FareEstimate>
}