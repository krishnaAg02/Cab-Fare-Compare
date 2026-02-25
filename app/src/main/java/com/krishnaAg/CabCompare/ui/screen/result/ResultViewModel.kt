package com.krishnaAg.CabCompare.ui.screen.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishnaAg.CabCompare.data.model.FareEstimate
import com.krishnaAg.CabCompare.data.model.LocationPoint
import com.krishnaAg.CabCompare.domain.usecase.GetFareComparisonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ResultUiState {
    object Idle : ResultUiState()
    object Loading : ResultUiState()
    data class Success(val fares: List<FareEstimate>) : ResultUiState()
    data class Error(val message: String) : ResultUiState()
}

class ResultViewModel(
    private val useCase: GetFareComparisonUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ResultUiState>(ResultUiState.Idle)
    val uiState: StateFlow<ResultUiState> = _uiState.asStateFlow()

    fun loadFares(pickup: LocationPoint, drop: LocationPoint) {
        viewModelScope.launch {
            _uiState.value = ResultUiState.Loading
            try {
                val fares = useCase.invoke(pickup, drop)
                if (fares.isEmpty()) {
                    _uiState.value = ResultUiState.Error("No cabs found for this route")
                } else {
                    _uiState.value = ResultUiState.Success(fares.sortedBy { it.price })
                }
            } catch (e: Exception) {
                _uiState.value = ResultUiState.Error(e.localizedMessage ?: "Something went wrong")
            }
        }
    }
}
