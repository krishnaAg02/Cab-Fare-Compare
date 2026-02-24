package com.krishnaAg.CabCompare.domain.repository

import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint

interface CabRepository {
    suspend fun getFareEstimates(
        pickup: LocationPoint,
        drop: LocationPoint
    ): List<FareEstimate>
}