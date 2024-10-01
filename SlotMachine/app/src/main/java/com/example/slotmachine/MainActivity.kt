package com.example.slotmachine

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slotmachine.ui.theme.SlotMachineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlotMachineTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    ) { innerPadding ->
                    RunSlots(modifier = Modifier,
                    //SlotMachine(modifier = Modifier

                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun RunSlots(modifier: Modifier = Modifier) {
    SlotMachine(modifier = Modifier
        .fillMaxSize(),
        )

}

@Composable
fun TestingImage(modifier: Modifier = Modifier) {
    Image (
        painterResource(id = R.drawable.tennisracket),
        contentDescription = "hel"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SlotMachine(modifier: Modifier = Modifier) {
    val casinoFont = FontFamily(
        Font(R.font.casinoshadowitallic, FontWeight.Normal)
    )
    var winorlose = "PRESS SPIN TO SPIN"
    var imageOne by remember { mutableStateOf(slotOdds()) }
    var imageTwo by remember { mutableStateOf(slotOdds()) }
    var imageThree by remember { mutableStateOf(slotOdds()) }
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        topBar = {
            TopAppBar(
                title = {
                Text(
                    text = "SPORTS SLOTS",
                    fontSize = 60.sp,
                    fontFamily = casinoFont,
                    //modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )},

                colors = TopAppBarColors(
                    containerColor = Color.Black, //changes color of our topBar
                    scrolledContainerColor = Color.Magenta, //doesn't apply to our project
                    navigationIconContentColor = Color.Cyan, //doesn't apply to our project
                    titleContentColor = colorResource(id = R.color.titlecolor), //text color
                    actionIconContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ){
        Column (
            modifier = Modifier
                .fillMaxSize(),
                //.background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            Row(
                modifier = Modifier,
                //.weight(.1f),
                verticalAlignment = Alignment.CenterVertically, //arent required as column does it for us
                horizontalArrangement = Arrangement.Center //column centers for us
            ) {
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    painter = painterResource(id = imageOne),
                    contentDescription = "hello"
                )
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    painter = painterResource(id = imageTwo),
                    contentDescription = "hello"
                )
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    painter = painterResource(id = imageThree),
                    contentDescription = "hello"
                )
            }
            Spacer(modifier = Modifier
                .height(12.dp))
            Button(
                onClick = {
                    imageOne = slotOdds()
                    imageTwo = slotOdds()
                    imageThree = slotOdds()
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                ),
                modifier = Modifier
                    .padding(24.dp)
            ) {
                Text(
                    text = "SPIN",
                    fontFamily = casinoFont,
                    fontSize = 24.sp,
                    color = Color.White
                )
            }


            if (imageOne == imageTwo && imageTwo == imageThree) {
                winorlose = "JACKPOT!!!! YOU WIN"

            } else if (imageOne == imageTwo || imageTwo == imageThree || imageOne == imageThree){
                winorlose = "TWO OF A KIND!!!!"

            } else {
                winorlose = "YOU LOST!"
            }
            //winorlose = "JACKPOT!!!! YOU WIN"
            Spacer(modifier = Modifier
                .padding(30.dp))

            Text(
                text = winorlose,
                fontFamily = casinoFont,
                fontSize = 50.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                textAlign = TextAlign.Center,
                lineHeight = 40.sp, //prevents overlap with our "WIN" word
                color = Color.Black
            )
        }
    }
}


fun slotOdds(modifier: Modifier = Modifier) : Int {
    val random_num = (1..9).random()
    val imageResource = when (random_num) {
        1 -> R.drawable.baseball
        2 -> R.drawable.baseballbat
        3 -> R.drawable.basketball
        4 -> R.drawable.football
        5 -> R.drawable.hockeypuck
        6 -> R.drawable.hockeystick
        7 -> R.drawable.soccerball
        8 -> R.drawable.tennisball
        9 -> R.drawable.tennisracket
        else -> R.drawable.error
    }
    return imageResource
}





