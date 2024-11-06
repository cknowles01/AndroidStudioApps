package com.example.recipesattempt2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    private val selectedIngredients: List<String> = emptyList()



    fun toggleIngredientSelection(ingredient: String) {
        _uiState.update { currentState ->
            val updatedIngredients = if (currentState.selectedIngredients.contains(ingredient)) {
                currentState.selectedIngredients - ingredient
            } else {
                currentState.selectedIngredients + ingredient
            }
            currentState.copy(selectedIngredients = updatedIngredients)
        }
    }




    fun setRecipe(recipe: Recipe) {
        _uiState.update { currentState ->
            currentState.copy(
                name = recipe.name,
                image = recipe.image,
                ingredients = recipe.ingredients,
                selectedRecipe = recipe,
            )
        }
    }




}