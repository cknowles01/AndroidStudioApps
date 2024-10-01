package com.example.restaurantsapp

import androidx.compose.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import com.example.restaurantsapp.ui.theme.RestaurantsAppTheme

@Composable
fun RestaurantScreen() {
    RestaurantItem()
}

@Composable
fun RestaurantItem() {
    Card(elevation = 4.dp,
        modifier = Modifier.padding()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(8.dp))
        {
            RestaurantIcon(
                Icons.Filled.Place,
                Modifier.weight(0.15F))
            RestaurantDetails(Modifier.weight(0.85F)
            )
        }

    }
}


@Composable
private fun RestaurantIcon(icon : ImageVector, modifier: Modifier = Modifier) {
    Image(imageVector = icon,
        contentDescriptoion = "Restaurant Icon",
        modifier = modifier.padding(8.dp))
}

@Composable
private fun RestaurantDetails(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Alfredo's dishes",
            style = MaterialTheme.typography.headlineLarge)
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium) {
            Text(text = "At Alfredo's ... seafood fidshes",
                style = MaterialTheme.typography.bodySmall)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestaurantsAppTheme {
        RestaurantScreen()
    }


}

