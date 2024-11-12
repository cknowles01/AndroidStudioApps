package com.example.cityapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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
fun CategoryScreen(
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
fun CityApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "category") {
        composable("category") {
            // Pass a sample list of places in each category for testing
            CategoryScreen(
                categoryName = "Restaurants",
                places = listOf(
                    Place("Restaurant", "Restaurant A", "Details about Restaurant A", "d"),
                    Place("Restaurant", "Restaurant B", "Details about Restaurant B", "d"),
                    Place("Restaurant", "Restaurant C", "Details about Restaurant C", "d")
                )
            ) { selectedPlace ->
                // Navigate to details screen, passing place as a Parcelable
                navController.navigate("details/${selectedPlace.name}")
            }
        }
        composable(
            "details/{placeName}",
            arguments = listOf(navArgument("placeName") { type = NavType.StringType })
        ) { backStackEntry ->
            val placeName = backStackEntry.arguments?.getString("placeName") ?: ""
            //val place = findPlaceByName(placeName) // implement this function to retrieve the selected place

        }
    }
}





