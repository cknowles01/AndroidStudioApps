package com.example.recipesattempt2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.recipesattempt2.OrderViewModel
import com.example.recipesattempt2.R
import com.example.recipesattempt2.Recipe
import androidx.compose.ui.Modifier



@Composable
fun RecipesScreen(
    recipes: List<Recipe>,
    selectedRecipe: Recipe?,
    onRecipeSelect: (Recipe) -> Unit,
    onIngredientToggle: (String) -> Unit,
    selecedIngredients: List<String>
) {
    Column {
        Text(text = "Recipe")

        recipes.forEach { recipe ->
            RecipeItem(
                recipe = recipe,
                isSelected = recipe == selectedRecipe ,
                onSelect = { onRecipeSelect(recipe) },
                onIngredientToggle = onIngredientToggle,
                selectedIngredients = selecedIngredients
            )
        }
    }
}


@Composable
fun RecipeItem(
    recipe: Recipe,
    isSelected: Boolean,
    onSelect: () -> Unit,
    onIngredientToggle: (String) -> Unit,
    selectedIngredients: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onSelect() }
    ) {
        Text(text = recipe.name)
        Image(
            painter = painterResource(recipe.image),
            contentDescription = null,
        )

        if (isSelected) {
            Text(text = "Ingredients:")

            recipe.ingredients.forEach { ingredient ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onIngredientToggle(ingredient) }
                        .padding(4.dp)
                ) {
                    Checkbox(
                        checked = selectedIngredients.contains(ingredient),
                        onCheckedChange = { onIngredientToggle(ingredient)}
                    )
                }
            }
        }
    }


}

