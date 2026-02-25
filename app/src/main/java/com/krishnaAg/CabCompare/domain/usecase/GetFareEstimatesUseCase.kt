package com.krishnaAg.CabCompare.domain.usecase

import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint
import com.krishnaAg.CabCompare.domain.repository.CabRepository

class GetFareEstimatesUseCase(
    private val repository: CabRepository
) {
    suspend operator fun invoke(
        pickup: LocationPoint,
        drop: LocationPoint
    ): Result<List<FareEstimate>> {
        return try {
            val estimates = repository.getFareEstimates(pickup, drop)
            Result.success(estimates.sortedBy { it.price })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
