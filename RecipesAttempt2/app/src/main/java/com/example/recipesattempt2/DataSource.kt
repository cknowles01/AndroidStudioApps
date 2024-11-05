package com.example.recipesattempt2

data class Recipe(
    val name: String,
    val image: Int,
    val ingredients: List<String>
)


object DataSource {
    val recipes = listOf(
        Recipe("Burger", R.drawable.burger, listOf("Beef", "Bun", "Lettuce")),
        Recipe("Pizza", R.drawable.pizza, listOf("Cheese", "Dough", "Tomato Sauce")),
        Recipe("Clam Chowder", R.drawable.clamchowder, listOf("Clams", "Cream", "Onions", "Bacon", "Celery"))

    )
}