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

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val motionViewModel: MotionViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(text = "${motionViewModel.xAcc}")
                    Text(text = "${motionViewModel.yAcc}")
                    Text(text = "${motionViewModel.zAcc}")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FitnessAppTheme {
        Greeting("Android")
    }
}