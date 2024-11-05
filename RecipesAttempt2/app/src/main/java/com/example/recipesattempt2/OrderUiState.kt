package com.example.recipesattempt2

data class OrderUiState(
    val name: String = "",
    val image: Int = 0,
    val ingredients: List<String> = listOf(),
    val selectedIngredients: List<String> = emptyList(),
    val selectedRecipe: Recipe? = null
)



