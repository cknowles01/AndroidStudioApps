package com.example.restaurantsscreen
import java.lang.reflect.Modifier
import androidx.compose.*
@Composable
fun RestaurantsScreen() {
    RestaurantItem()
}

@Composable
fun RestaurantItem() {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
    ) {

    }
}