package com.example.slotmachine.userint

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.slotmachine.R
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun TestingImage(modifier: Modifier = Modifier) {
    Image (
        painterResource(id = R.drawable.tennisracket),
        contentDescription = "hel"
    )
}


@Composable
fun SlotMachineScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()

    val isGameOver = gameUiState.isGameOver
    var money = gameUiState.money
    val currentSlots = gameUiState.currentSlots
    val onSpin = gameViewModel.spinSlots()
    val onRestart = gameViewModel.resetGame()
    //val onCashOut = gameViewModel.



    if (isGameOver == false) {
        GameOverDialogue(onRestart = { onRestart })
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Money: $$money")
            Spacer(modifier = Modifier.height(16.dp))

            Row {
                currentSlots.forEach { slotImage ->
                    Image(
                        painter = painterResource(id = slotImage),
                        contentDescription = null,
                        modifier = Modifier.size(8.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onSpin }) {
                Text("Spin")
            }
            Button(onClick = { onSpin }) {
                Text("Cash Out")
            }
        }
    }
}



@Composable
fun GameOverDialogue(onRestart: () -> Unit) {
    AlertDialog(
        onDismissRequest = {

        },
        title = { Text("Game Over!") },
        text = { Text("You're out of money! Would you like to play again??") },

        confirmButton = {
            Button(onClick = onRestart) {
                Text("Restart")
            }
        }
    )
}

fun slotOdds(modifier: Modifier = Modifier) : Int {
    val random_num = (1..9).random()
    return when (random_num) {
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

}





