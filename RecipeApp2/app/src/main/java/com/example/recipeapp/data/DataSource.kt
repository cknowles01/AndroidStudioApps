package com.example.recipeapp.data

import com.example.recipeapp.R
import com.example.recipeapp.model.RecipeItem

object DataSource {
    val Recipes = listOf(
        RecipeItem(
            name = "Cheeseburger",
            image = R.drawable.burger,
            ingredients = listOf("Beef", "Cheese"),
        ),
        RecipeItem(
            name = "Pizza",
            image = R.drawable.pizza,
            ingredients = listOf("Cheese", "Dough", "Pepperoni")
        ),
        RecipeItem(
            name = "Clam Chowder",
            image = R.drawable.clamchowder,
            ingredients = listOf("Clams", "Cream", "Celery")
        )
    )
}