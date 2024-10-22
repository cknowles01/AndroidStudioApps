package com.example.slotmachine.userint

import com.example.slotmachine.R

data class GameUiState(
    var money: Int = 1000,
    val currentSlots: List<Int> = listOf(R.drawable.error, R.drawable.error, R.drawable.error),
    val isGameOver: Boolean = false
)
