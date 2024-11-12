package com.example.cityapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrderViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()


    fun setTypeOfPlace(category: String) {
        val selectedPlaces = DataSource.places.find { it.categoryName == category }?.places ?: emptyList()
        _uiState.value = _uiState.value.copy(
            selectedCategory = category,
            placesList = selectedPlaces
        )
    }

    fun setSelectedPlace(place: Place) {
        _uiState.value =_uiState.value.copy(selectedPlace = place)
    }
}