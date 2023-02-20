package de.uniks.codecamp.group_a.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import de.uniks.codecamp.group_a.fitnessapp.ui.theme.FitnessAppTheme
import de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout.MotionViewModel
import de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout.StationaryWorkout
import de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout.StationaryWorkouts

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val motionViewModel: MotionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                    StationaryWorkout(type = StationaryWorkouts.SQUATS, motionViewModel)
                }
            }
        }
    }

@Composable
fun Debug(vm: MotionViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "${vm.xAcc}")
        Text(text = "${vm.yAcc}")
        Text(text = "${vm.zAcc}")
        Text(text = vm.state.name)
}}