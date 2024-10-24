package com.example.slotmachine.userint

import androidx.lifecycle.ViewModel
import com.example.slotmachine.R


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private fun updateMoney(updatedBalance: Int) {
        val currentBalance = _uiState.value.money
        val newBalance = currentBalance + updatedBalance
        if (newBalance <= 0) {
            _uiState.value = _uiState.value.copy(money = 0, isGameOver = true)
        } else {
            _uiState.value = _uiState.value.copy(money = newBalance)
        }
    }

    fun spinSlots() {
        val slot1 = slotOdds()
        val slot2 = slotOdds()
        val slot3 = slotOdds()
        _uiState.value = _uiState.value.copy(currentSlots = listOf(slot1, slot2, slot3))
        slotResults(slot1, slot2, slot3)
    }

    private fun slotResults(slot1: Int, slot2: Int, slot3: Int) {

        if  (slot1 == slot2 && slot1 == slot3) { //all three in a row
            updateMoney(10000)
        } else if (slot1 == slot2 || slot1 == slot3 || slot2 == slot3) { //two pair
            updateMoney(150)
        } else {                                            //none
            updateMoney(-100)
        }
    }

    fun resetGame() {
        _uiState.value.money = 1000
        _uiState.value = _uiState.value.copy(isGameOver = false)
        _uiState.value.currentSlots = listOf(R.drawable.error, R.drawable.error, R.drawable.error)
    }

    fun cashOut() {
        if (_uiState.value.maxMoney < _uiState.value.money) _uiState.value.maxMoney = _uiState.value.money

        _uiState.value.money = 1000
        _uiState.value = _uiState.value.copy(isGameOver = false)
        _uiState.value.currentSlots = listOf(R.drawable.error, R.drawable.error, R.drawable.error)
    }

    fun gameOver() {
        _uiState.value.money = 10000
    }
}