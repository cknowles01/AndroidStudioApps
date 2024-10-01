package com.example.businesscard

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF9FAEF8)
                ) {

                }
                Name(name = "Connor Knowles", desc = "Pro Developer")
            }
        }
    }
}
@Composable
fun AndroidImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth(0.3F)
    )
}

@Preview(showBackground = true)
@Composable
fun NamePreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF8EECFA)
        ) {
            Name("Connor Knowles", "Experienced Andriod Developer")
        }
    }
}


@Composable
fun Name(name: String, desc: String, modifier: Modifier = Modifier) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {
            Spacer(modifier = Modifier
                .weight(.9F))
            AndroidImage()
            Text(
                text = name,
                fontSize = 36.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    //.padding(8.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = desc,
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF155A2C),
                modifier = Modifier
                    //.padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally),
            )
            Spacer(modifier = Modifier
                .weight(1f)
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
            )
            ContactInfo(
                number = "123-456-7890",
                socialmedia = "@connorknowles",
                email = "connor@gmail.com"
            )

        }
    }

}

@Composable
fun ContactInfo(number: String, socialmedia: String, email: String, modifier: Modifier = Modifier) {
        Column (modifier = modifier
            .fillMaxWidth()
            .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
            modifier = Modifier
                .padding(4.dp)
                .align(alignment = Alignment.CenterHorizontally)

            ) {
                Icon (
                    imageVector = Icons.Default.Phone,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = number,
                    modifier = Modifier
                        .padding(4.dp)


                )
            }
            Row(
            modifier = Modifier
                .padding(4.dp)
                .align(alignment = Alignment.CenterHorizontally)
            ) {
                Icon (
                    imageVector = Icons.Default.Share,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )


                Text(
                    text = socialmedia,
                    modifier = Modifier
                        .padding(4.dp)

                    )
                }
            Row(
            modifier = Modifier
                .padding(4.dp)
                .align(alignment = Alignment.CenterHorizontally)
            ) {
                Icon (
                    imageVector = Icons.Default.Email,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )


                Text(
                    text = email,
                    modifier = Modifier
                        .padding(4.dp)

                )
            }

    }
}