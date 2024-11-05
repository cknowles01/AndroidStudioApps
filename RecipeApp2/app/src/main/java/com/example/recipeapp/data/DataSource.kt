package com.example.recipeapp.data

import com.example.recipeapp.R
import com.example.recipeapp.model.RecipeItem

object DataSource {
    val Recipes = listOf(
        RecipeItem(
            name = "Cheeseburger",
            image = R.drawable.burger,
            listOf = ("Beef, Buns, Cheese, and Lettuce"),
        ),
        RecipeItem(
            name = "Pizza",
            image = R.drawable.pizza,
            listOf = ("Cheese, Pepperoni, Tomato sauce and Dough")
        ),
        RecipeItem(
            name = "Clam Chowder",
            image = R.drawable.clamchowder,
            listOf = ("Clams, Potatoes, cream, onions, and celery")
        )
    )
}