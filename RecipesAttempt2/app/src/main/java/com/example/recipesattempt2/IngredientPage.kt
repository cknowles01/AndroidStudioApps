package com.example.recipesattempt2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun IngredientsPage(

    onBack: () -> Unit,
    selectedIngredients: List<String>,
    onIngredientToggle: (String) -> Unit
) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {


        selectedIngredients.forEach { ingredient ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            ) {
                Checkbox(
                    checked = selectedIngredients.contains(ingredient),
                    onCheckedChange = { isChecked ->
                        onIngredientToggle(ingredient)
                    },
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = ingredient
                )
            }
        }
    }
}



