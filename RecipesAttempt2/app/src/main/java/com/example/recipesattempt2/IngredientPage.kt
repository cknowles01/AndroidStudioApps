package com.example.recipesattempt2

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun IngredientsPage(recipe: Recipe, onBack: () -> Unit, selectedIngredients: List<String>,  onIngredientToggle: (String) -> Unit

){
    selectedIngredients.forEach { ingredient ->
        Text(ingredient)
    }

    }

