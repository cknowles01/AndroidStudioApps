package com.example.recipeapp

import android.view.MenuItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipeapp.model.RecipeItem

@Composable
fun BaseScreen(
    options: List<RecipeItem>,
    modifier: Modifier = Modifier,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectionChanged: (RecipeItem) -> Unit
) {
    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        options.forEach { item ->

            val onClick = {
                selectedItemName = item.name
                onSelectionChanged(item)
            }
        }
    }

@Composable
fun RecipeRow(
     item: RecipeItem,
     selectedItemName: String,
     onClick: () -> Unit,
     modifier: Modifier = Modifier
) {
     Row(
        modifier = modifier,
         verticalAlignment = Alignment.CenterVertically
     ) {
         RadioButton(
             selected = selectedItemName == item.name,
             onClick = onClick
         )
         Column(
             verticalArrangement = Arrangement.spacedBy(8.dp)
         ) {
             Text(
                 text = item.name,
                 style = MaterialTheme.typography.headlineSmall
             )
             Text(
                 text = item.listOf,
                 style = MaterialTheme.typography.headlineSmall
             )

         }
     }
}

@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
            Text("Cancel")
        }
        Button(
            modifier = Modifier.weight(1f),
            // the button is enabled when the user makes a selection
            enabled = selectedItemName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text("Next".uppercase())
        }
    }
}
}



