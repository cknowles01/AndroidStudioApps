package com.example.recipesattempt2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipesattempt2.R
import com.example.recipesattempt2.Recipe
import java.lang.reflect.Modifier

@Composable
fun SelectRecipeScreen(
    viewModel: RecipeViewModel,
    onRecipeSelected: (Recipe) -> Unit // Callback for navigation
) {
    val recipes by viewModel.recipes.collectAsState() // Get recipes from ViewModel
    val selectedRecipe by viewModel.selectedRecipe.collectAsState() // Track selected recipe

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Select Recipe") })
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(recipes) { recipe ->
                RecipeListItem(
                    recipe = recipe,
                    isSelected = selectedRecipe?.id == recipe.id,
                    onSelect = {
                        viewModel.selectRecipe(recipe)
                        onRecipeSelected(recipe) // Navigate to details or next screen
                    }
                )
            }
        }
    }
}

@Composable
fun RecipeListItem(recipe: Recipe, isSelected: Boolean, onSelect: () -> Unit) {
    Row(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onSelect() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.clamchowder),
            contentDescription = recipe.name,
            //modifier = Modifier.size(56.dp).clip(RoundedCornerShape(4.dp))
        )

        Text(text = recipe.name)
        Spacer(modifier = Modifier.weight(1f))
        Checkbox(
            checked = isSelected,
            onCheckedChange = { onSelect() }
        )
    }
}
