package com.example.cityapp

import kotlinx.coroutines.flow.MutableStateFlow

data class OrderUiState(
    val id: Int = 0,
    val category: String = "",
    val name: String = "",
    val details: String = "",
    val selectedCategory: String? = null,
    val placesList: List<Place> = emptyList(),
    val selectedPlace: Place? = null
) : MutableStateFlow<OrderUiState>