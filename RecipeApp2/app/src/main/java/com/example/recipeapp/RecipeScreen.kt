package com.example.recipeapp

import android.view.MenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.recipeapp.model.RecipeItem
import com.example.recipeapp.model.RecipeItem.FoodItem
@Composable
fun RecipeScreen(
    options: List<RecipeItem>,
    onCancelButtonSelected: () -> Unit,
    onNextButtonSelected: () -> Unit,
    onSelectionChanged: (FoodItem) -> Unit,
    modifier: Modifier = Modifier
) {
    BaseScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonSelected,
        onNextButtonClicked = onNextButtonSelected,
        onSelectionChanged = onSelectionChanged as (RecipeItem) -> Unit,
        modifier = modifier
    )
}