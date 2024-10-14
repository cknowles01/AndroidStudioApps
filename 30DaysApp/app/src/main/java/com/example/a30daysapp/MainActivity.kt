package com.example.a30daysapp

import android.os.Bundle

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.remember
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.foundation.indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource





import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysapp.data.Tip
import com.example.a30daysapp.data.tips

import com.example.a30daysapp.ui.theme._30DaysAppTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ThirtyDaysApp(
                        
                    )
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysApp() {
    Scaffold (

    ) {
        LazyColumn (contentPadding = it) {
            items(tips) {
                QuoteCard(
                    tip = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_24))
                )
            }
        }
    }

}

@Composable
fun QuoteCard(
    tip: Tip,
    modifier: Modifier = Modifier,
    ) {

    var expanded by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (expanded) 1.10f else 1f,
        animationSpec = tween(durationMillis = 300)
    )



    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                onClick = { expanded = !expanded },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .scale(scale)
            .padding(dimensionResource(id = R.dimen.padding_8))
    ) {
        Column() {
            Row(
                modifier = modifier
                    .scale(scale)
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_16))
            ) {
                TipInformation(day = tip.day, name = tip.tipname, quote = tip.quote)
            }

        }
    }
}
    /*Card(
        modifier = modifier
            //.fillMaxWidth()
            //.wrapContentHeight()
            .clickable(
                onClick = {},
                interactionSource = remember { MutableInteractionSource() },
            )
            //.animateContentSize()
            .scale(scale)
            .padding(dimensionResource(id = R.dimen.padding_8)),
            //.clip(RoundedCornerShape(dimensionResource(R.dimen.corner))),

        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.elevation))


    ) {
        Column() {
            Row(
                modifier = modifier
                    .scale(scale)
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_16))
            ) {
                TipInformation(day = tip.day, name = tip.tipname, quote = tip.quote)
            }

        }
    }

}
*/


@Composable
fun TipInformation(
    @StringRes day: Int,
    @StringRes name: Int,
    @StringRes quote: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(day),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_8))
        )
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_16))
        )
        Text(
            text = stringResource(quote),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_24))
        )
    }

}







@Preview
@Composable
fun ThirtyDaysPreview() {
    ThirtyDaysApp()
}

@Preview
@Composable
fun ThirtyDaysPreviewDark() {
    _30DaysAppTheme(darkTheme = true) {
        ThirtyDaysApp()
    }
}