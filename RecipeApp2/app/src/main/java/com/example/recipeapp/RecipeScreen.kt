package com.example.recipeapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipeapp.model.RecipeItem.FoodItem
@Composable
fun RecipeScreen(
    options: List<FoodItem>,
    onCancelButtonSelected: () -> Unit,
    onNextButtonSelected: () -> Unit,
    onSelectionChanged: (FoodItem) -> Unit,
    modifier: Modifier = Modifier
) {

}