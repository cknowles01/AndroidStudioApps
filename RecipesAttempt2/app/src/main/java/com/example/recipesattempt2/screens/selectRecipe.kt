package com.example.recipesattempt2.screens

import android.annotation.SuppressLint
import android.telecom.Call.Details
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.recipesattempt2.OrderViewModel
import com.example.recipesattempt2.R
import com.example.recipesattempt2.Recipe
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipesattempt2.DataSource
import com.example.recipesattempt2.DetailsScreen


enum class RecipeScreen(@SuppressLint("SupportAnnotationUsage") @StringRes val title: String) {
    Start(title = "Select Recipe"),
    Details(title = "More details"),
    Ingredients(title = "Ingredient list")
}



@Composable
fun RecipesScreen(
    recipes: List<Recipe>,
    selectedRecipe: Recipe?,
    onRecipeSelect: (Recipe) -> Unit,
    onIngredientToggle: (String) -> Unit,
    selecedIngredients: List<String>
) {
    Column {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeAppBar(
    currentScreen: RecipeScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(currentScreen.title) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "goback"
                    )
                }
            }
        }
    )
}




@Composable
fun RecipeApp(
    //viewModel: OrderViewModel = viewModel(),
    viewModel: OrderViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
    ){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = RecipeScreen.valueOf(
        backStackEntry?.destination?.route ?: RecipeScreen.Start.name
    )
    Scaffold(
        topBar = {
            RecipeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = RecipeScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = RecipeScreen.Start.name) {
                    RecipesScreen(
                        recipes = DataSource.recipes,
                        selectedRecipe = uiState.selectedRecipe,
                        onRecipeSelect = { selectedRecipe ->
                            viewModel.setRecipe(selectedRecipe)
                            navController.navigate(RecipeScreen.Details.name)
                        },
                        onIngredientToggle = { ingredient ->
                            viewModel.toggleIngredientSelection(ingredient)
                        },
                        selecedIngredients = uiState.selectedIngredients
                    )

            }
            composable(route = RecipeScreen.Details.name) {
                val selectedIngredients = uiState.selectedIngredients
                val context = LocalContext.current

                uiState.selectedRecipe?.let { it1 ->
                    DetailsScreen(
                        recipe = it1,
                        onBack = { navController.popBackStack() },
                        selectedIngredients = selectedIngredients,
                        onIngredientToggle = { ingredient ->
                            viewModel.toggleIngredientSelection(ingredient)
                        })
                }


                }

            }

            
        }

    }






