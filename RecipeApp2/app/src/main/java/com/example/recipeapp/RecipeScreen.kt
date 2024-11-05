package com.example.recipeapp

import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recipeapp.model.RecipeItem
import com.example.recipeapp.model.RecipeItem.FoodItem

@Composable
fun RecipeListScreen(navController: NavHostController) {
    // Sample data
    val sampleRecipes = listOf(
        Recipe("Hamburger", R.drawable.burger, listOf("Beef", "Cheese", "Bun")),
        Recipe("Pizza", R.drawable.pizza, listOf("Cheese", "Pepperoni", "Dough")),
        Recipe("Clam Chowder", R.drawable.clamchowder, listOf("Clams", "Onions", "Cream", "Bacon"))
    )

    // LazyColumn to display the list of recipes
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(sampleRecipes) { recipe ->
            RecipeItem(recipe) {
                // Navigate to the detail screen when a recipe is clicked
                navController.navigate("recipeDetail/${recipe.name}")
            }
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = recipe.imageUrl),
            contentDescription = recipe.name,
            modifier = Modifier.size(64.dp).padding(end = 8.dp) // Adjust size as needed
        )
        Column {
            Text(text = recipe.name, style = MaterialTheme.typography.titleMedium)
            //Text(text = recipe., style = MaterialTheme.typography.bodyMedium)
        }
    }
}