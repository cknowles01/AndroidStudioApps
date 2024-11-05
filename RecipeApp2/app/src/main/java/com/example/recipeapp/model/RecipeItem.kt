package com.example.recipeapp.model

class RecipeItem(
    open val name: String,
    open val image: Int,
    open val ingredients: List<String>
) {
    data class FoodItem(
        val name: String,
        val image: Int,
        val ingredients: List<String>
    )
}


