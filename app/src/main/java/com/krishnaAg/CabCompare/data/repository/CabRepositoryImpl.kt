package com.krishnaAg.CabCompare.data.repository

import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint
import com.krishnaAg.CabCompare.data.remote.api.CabApiService
import com.krishnaAg.CabCompare.domain.repository.CabRepository

class CabRepositoryImpl(
    private val apiService: CabApiService
) : CabRepository {

    override suspend fun getFareEstimates(
        pickup: LocationPoint,
        drop: LocationPoint
    ): List<FareEstimate> {
        return apiService.fetchFareEstimates(pickup, drop)
    }
}
