package com.krishnaAg.CabCompare.data.remote.api

import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint
import kotlinx.coroutines.delay


class MockCabApiService : CabApiService {

    override suspend fun fetchFareEstimates(
        pickup: LocationPoint,
        drop: LocationPoint
    ): List<FareEstimate> {

        delay(1000) // simulate network delay

        return listOf(
            FareEstimate("Uber", "Mini", 220.0, 4, "uber://"),
            FareEstimate("Ola", "Mini", 210.0, 6, "ola://"),
            FareEstimate("Rapido", "Bike", 120.0, 3, "rapido://")
        )
    }
}