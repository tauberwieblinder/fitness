package de.uniks.codecamp.group_a.fitnessapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

abstract class MotionSensor(
    context: Context,
    sensorType: Int,
    sensorFeature: String
) : SensorEventListener {

    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var sensor: Sensor? = sensorManager.getDefaultSensor(sensorType)

    val sensorExists: Boolean = context.packageManager.hasSystemFeature(sensorFeature)

    private var onValueChange: ((List<Float>) -> Unit)? = null

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) = Unit

    override fun onSensorChanged(p0: SensorEvent?) {
        if (!sensorExists || p0 == null) {
            return
        }

        onValueChange?.invoke(p0.values.asList())
    }

    fun startListening() {
        if (!sensorExists) {
            return
        }
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun stopListening() {
        sensorManager.unregisterListener(this)
    }

    fun setOnValueChange(listener: ((List<Float>) -> Unit)) {
        onValueChange = listener
    }
}