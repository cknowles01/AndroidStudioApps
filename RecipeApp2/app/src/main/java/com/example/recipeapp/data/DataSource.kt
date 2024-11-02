package com.example.recipeapp.data

import com.example.recipeapp.R
import com.example.recipeapp.model.RecipeItem

object DataSource {
    val Recipes = listOf(
        RecipeItem(
            name = "Cheeseburger",
            desc = "",
            image = R.drawable.burger
        ),
        RecipeItem(
            name = "Pizza",
            desc = "",
            image = R.drawable.pizza
        ),
        RecipeItem(
            name = "Clam Chowder",
            desc = "",
            image = R.drawable.clamchowder
        )
    )
}