package com.krishnaAg.CabCompare.domain.usecase

import com.krishnaAg.CabCompare.data.model.LocationPoint
import com.krishnaAg.CabCompare.domain.repository.CabRepository

class GetFareComparisonUseCase(
    private val repository: CabRepository
) {
    suspend operator fun invoke(pickup: LocationPoint, drop: LocationPoint) =
        repository.getFareEstimates(pickup, drop)
}