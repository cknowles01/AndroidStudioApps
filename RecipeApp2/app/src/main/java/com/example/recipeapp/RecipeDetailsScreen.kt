package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipeapp.model.RecipeItem


@Composable
fun RecipeDetailsScreen(recipe: Recipe, onBackPressed: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Display the recipe name
        Text(text = recipe.name, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))

        // Display ingredients in a list
        recipe.ingredients.forEach { ingredient ->
            Text(text = ingredient, style = MaterialTheme.typography.body1)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBackPressed) {
            Text(text = "Back")
        }
    }
}

@Composable
fun RecipeDetail(recipe: Recipe) {
    Column {
        Text(text = recipe.name, style = MaterialTheme.typography.h5)
        Image(painter = painterResource(id = recipe.image), contentDescription = null)
        // List the ingredients
        recipe.ingredients.forEach { ingredient ->
            Text(text = ingredient)
        }
    }
}


