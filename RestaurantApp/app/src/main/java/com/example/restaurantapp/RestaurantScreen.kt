package com.example.restaurantsapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import com.example.restaurantapp.Restaurant
import com.example.restaurantapp.dummyRestaurants
import com.example.restaurantapp.ui.theme.RestaurantAppTheme


/*@Composable
fun RestaurantScreen() {
    Column (Modifier.verticalScroll(rememberScrollState())
        //.padding(16.dp))
        .padding(8.dp)
        .statusBarsPadding()
    ){
        dummyRestaurants.forEach { restaurant -> RestaurantItem(restaurant)
        Spacer(modifier = Modifier.height(8.dp))
        }

    }
}*/

@Composable
fun RestaurantScreen() {
    LazyColumn (
        Modifier
            .statusBarsPadding(),
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        ))
    {
        items(dummyRestaurants) { restaurant -> RestaurantItem(restaurant);
            Spacer(modifier = Modifier.height(16.dp))
    }


    }

}




@Composable
fun RestaurantItem(item: Restaurant) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.padding()
    ) {
        //Spacer(modifier = Modifier.weight(5F))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(8.dp))
        {
            RestaurantIcon(
                Icons.Filled.Place,
                Modifier.weight(0.15F))
            RestaurantDetails(
                item.title,
                item.description,
                Modifier.weight(0.85F),
            )
        }

    }
}


@Composable
private fun RestaurantIcon(icon : ImageVector, modifier: Modifier = Modifier) {
    Image(imageVector = icon,
        contentDescription = "Restaurant Icon",
        modifier = modifier.padding(8.dp))
}

@Composable
private fun RestaurantDetails(title: String, description: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = title,
            style = MaterialTheme.typography.headlineLarge)
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = description,
                style = MaterialTheme.typography.bodySmall)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestaurantAppTheme {
        RestaurantScreen()
    }


}
