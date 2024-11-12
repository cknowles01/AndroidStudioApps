package com.example.cityapp

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


enum class PlaceScreen(@StringRes val title: String) {
    Start(title = "Starting place"),
    Group(title = "Group"),
    Details(title = "more detainsl")
}


@Composable
fun DetailsScreen(place: Place) {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = place.name,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = place.details
        )
    }
}

@Composable
fun PlaceItem(
    place: Place,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onSelect() }
    ) {
        Text(
            text = place.name
        )
    }
}

@Composable
fun CategoryScreen( //second screen
    categoryName: String,
    places: List<Place>,
    onPlaceSelected: (Place) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = categoryName,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {
            items(places) { place ->
                PlaceItem(
                    place = place,
                    onSelect = { onPlaceSelected(place) }
                )
            }
        }
    }
}

@Composable
fun PlacesItems( //first screen
    onClick: (String) -> Unit,
) {
    val categories = DataSource.places.map { it.categoryName}

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(categories) { category ->
            Text(
                text = category,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onClick(category) }
            )
        }
    }
}

@Composable
fun CityApp(
    viewModel: OrderViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
    ) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = PlaceScreen.valueOf(
        backStackEntry?.destination?.route ?: PlaceScreen.Start.name
    )
    Scaffold {
        innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PlaceScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PlaceScreen.Start.name) {
                PlacesItems(
                    onClick = { categoryName ->
                        viewModel.setTypeOfPlace(categoryName)
                        navController.navigate(PlaceScreen.Group.name) }
                )
            }
            composable(route = PlaceScreen.Group.name) {
                CategoryScreen(
                    categoryName = uiState.selectedCategory ?: "",
                    places = uiState.placesList
                ) {

                }
                
            }
            composable(route = PlaceScreen.Details.name) {
                DetailsScreen(place = uiState.)
            }

        }
    }
}






