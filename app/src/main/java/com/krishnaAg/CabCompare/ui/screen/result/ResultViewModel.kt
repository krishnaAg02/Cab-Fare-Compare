package com.krishnaAg.CabCompare.ui.screen.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint
import com.krishnaAg.CabCompare.domain.usecase.GetFareComparisonUseCase
import kotlinx.coroutines.launch

class ResultViewModel(
    private val useCase: GetFareComparisonUseCase
) : ViewModel() {

    var fares: List<FareEstimate> = emptyList()
        private set

    fun loadFares(pickup: Any, drop: Any) {
        viewModelScope.launch {
            fares = useCase.invoke(pickup as LocationPoint, drop as LocationPoint)
        }
    }
}