package com.example.recipeapp

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.data.DataSource

enum class RecipeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    RecipeList(title = R.string.recipeList),
    SideDish(title = R.string.ingredientsList),
    Accompaniment(title = R.string.selectedIngredientsList),
    //Checkout(title = R.string.order_checkout)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.backButton)
                    )
                }
            }
        }
    )
}

@Composable
fun RecipeApp() {
    //Create NavController
    val navController = rememberNavController()
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = RecipeScreen.valueOf(
        backStackEntry?.destination?.route ?: RecipeScreen.Start.name
    )
    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            RecipeAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = RecipeScreen.RecipeList.name,
        ) {





            composable(route = RecipeScreen.RecipeList.name) {
                // State to keep track of the selected recipe
                var selectedRecipe by remember { mutableStateOf<Recipe?>(null) }

                RecipeListScreen(
                    options = DataSource.Recipes,
                    onRecipeSelected = { recipe ->
                        selectedRecipe = recipe // Update the selected recipe
                        // Navigate to the details screen
                        navController.navigate("recipeDetail/${recipe.name}")
                    },
                    onCancelButtonSelected = {
                        viewModel.clearGroceryList()
                        navController.popBackStack(RecipeScreen.Start.name, inclusive = false)
                    },
                    onNextButtonSelected = {
                        navController.navigate(RecipeScreen.SideDish.name)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )

                // If there's a selected recipe, show its details
                selectedRecipe?.let { recipe ->
                    RecipeDetailsScreen(
                        recipe = recipe, // Pass the selected recipe
                        onCancelButtonSelected = {
                            viewModel.clearGroceryList()
                            navController.popBackStack(RecipeScreen.Start.name, inclusive = false)
                        },
                        onNextButtonSelected = {
                            navController.navigate(RecipeScreen.SideDish.name)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }





        }
    }
}

