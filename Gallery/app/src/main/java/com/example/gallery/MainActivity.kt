package com.example.gallery

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.material3.Button
import androidx.compose.runtime.*


import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gallery.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalleryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtGallery(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtGallery(modifier: Modifier = Modifier) {
    var currentPicture by remember { mutableStateOf(1) }

    Column (modifier = modifier
        .fillMaxSize()
    ){
//        Spacer(modifier = Modifier
//            .weight(1f))
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1f)
            .padding(16.dp),
            contentAlignment = Alignment.Center


        ) {

            ChangePicture(pictureNumber = currentPicture)
        }
            //IMAGES SHOULD GO ABOVE HERE

            //THIS IS FOR THE BUTTONS

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.weight(1f)
                    .padding(16.dp),

                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    if (currentPicture > 1) currentPicture--
                }) {
                    Text(text = "backward")
                }
                Button(onClick = {
                    if (currentPicture < 8) currentPicture++
                }) {
                    Text(text = "forward")
                    Log.d("ArtGaller", "currentPicture = $currentPicture")
                }
            }


    }
}



@Composable
fun ChangePicture(pictureNumber: Int, modifier: Modifier = Modifier) {
    val imageResource = when (pictureNumber) {
        1 -> { R.drawable.crossing }
        2 -> { R.drawable.johannes_vermeer__1632_1675____the_girl_with_the_pearl_earring__1665_}
        3 -> { R.drawable.katsushikahokusaipaint_1600x_jpg}
        4 -> { R.drawable.mona_lisa__by_leonardo_da_vinci__from_c2rmf_retouched}
        5 -> { R.drawable.self_portrait_with_straw_hat_1887_88_857x1024}
        6 -> { R.drawable.the_persistence_of_memory}
        7 -> { R.drawable.the_scream}
        8 -> { R.drawable.the_starry_night_by_vincent_van_gogh_1889_800x}
        else -> { R.drawable.error}
    }
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        modifier = modifier.fillMaxWidth().aspectRatio(1f), //this will maintain the aspect ration of image
        contentScale = ContentScale.Fit //scales to fit image in the box
    )
}