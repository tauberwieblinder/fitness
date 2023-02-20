package de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class State {
    START,
    DOWN,
    PAUSE,
    UP
}

@HiltViewModel
class MotionViewModel @Inject constructor(
    val accSensor: AccelerationSensor
): ViewModel() {

    var state by mutableStateOf(State.START)
    // get height from settings when implemented
    private val height = 200f
    var distance = height / 3f

    var xAcc by mutableStateOf(0.0f)
    var yAcc by mutableStateOf(0.0f)
    var zAcc by mutableStateOf(0.0f)
    var repititions by mutableStateOf(0)

    init {
        accSensor.setOnValueChange { values ->
            xAcc = values[0]
            yAcc = values[1]
            zAcc = values[2]
            checkState()
        }
        startOrContinue()
    }

    fun startOrContinue() {
        accSensor.startListening()
    }

    fun stopOrPause() {
        accSensor.stopListening()
    }

    fun checkState() {
        when(state) {
            State.START -> {
                if (yAcc < 0.01f) {
                    state = State.DOWN
                }
            }
            State.DOWN -> {
                if (yAcc < 0.1f) {
                    state = State.PAUSE
                }
            }
            State.PAUSE -> {
                if (yAcc > 0.1f) {
                    state = State.UP
                }
            }
            State.UP -> {
                if (yAcc < 0.1f) {
                    state = State.START
                    repititions++
                    distance = height / 3
                }
            }
        }
    }

    fun getDistance(acc: Int, t: Float): Float {
        return 0.5f * acc * t
    }
}

