package com.example.recipesattempt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipesattempt2.screens.RecipeApp
import com.example.recipesattempt2.screens.RecipesScreen
import com.example.recipesattempt2.ui.theme.RecipesAttempt2Theme

class MainActivity : ComponentActivity() {

    private val orderViewModel: OrderViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipesAttempt2Theme {
                val uiState by orderViewModel.uiState.collectAsState()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    RecipesScreen(
//                        recipes = DataSource.recipes,
//                        selectedRecipe = uiState.selectedRecipe,
//                        onRecipeSelect = { recipe ->
//                            orderViewModel.setRecipe(recipe)
//                        },
//                        onIngredientToggle = {
//                            orderViewModel.toggleIngredientSelection(ingredient = "hi")
//                        },
//                        selecedIngredients = uiState.selectedIngredients
//                    )
                    RecipeApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecipesAttempt2Theme {
        Greeting("Android")
    }
}