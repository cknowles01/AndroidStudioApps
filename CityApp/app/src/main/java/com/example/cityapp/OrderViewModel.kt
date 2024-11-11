package com.example.cityapp

import kotlinx.coroutines.flow.MutableStateFlow

class OrderViewModel : ViewModel {
    private val _uiState = MutableStateFlow(OrderUiState())
}