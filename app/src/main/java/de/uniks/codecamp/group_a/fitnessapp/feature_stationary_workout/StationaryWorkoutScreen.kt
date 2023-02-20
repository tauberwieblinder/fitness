package de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StationaryWorkout(type: StationaryWorkouts, vm: MotionViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        TimerDisplay()
        StatisticsDisplay(vm = vm)
        ButtonsDisplay()
    }
}

@Composable
fun TimerDisplay() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "213")
        Text(text = "Seconds")
    }
}

@Composable
fun StatisticsDisplay(vm: MotionViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "${vm.repititions}")
            Text(text = "Repetitions")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "2")
            Text(text = "kCal burned")
        }
    }
}

@Composable
fun ButtonsDisplay() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Green),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green)
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = null)
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            border = BorderStroke(1.dp, Color.Green),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Green)
        ) {
            Icon(Icons.Filled.Star, contentDescription = null)
        }
    }
}