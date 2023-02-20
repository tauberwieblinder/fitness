package de.uniks.codecamp.group_a.fitnessapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MotionViewModel @Inject constructor(
    val accSensor: AccelerationSensor
): ViewModel() {

    var xAcc by mutableStateOf(0.0f)
    var yAcc by mutableStateOf(0.0f)
    var zAcc by mutableStateOf(0.0f)

    init {
        accSensor.setOnValueChange { values ->
            xAcc = values[0]
            yAcc = values[1]
            zAcc = values[2]
        }
        accSensor.startListening()
    }
}