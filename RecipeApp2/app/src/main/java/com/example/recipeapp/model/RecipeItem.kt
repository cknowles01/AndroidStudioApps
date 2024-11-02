package com.example.recipeapp.model

class RecipeItem(
    open val name: String,
    open val desc: String,
    open val image: Int,
) {
    data class FoodItem(
        val name: String,
        val desc: String,
        val image: Int,
    )
}


