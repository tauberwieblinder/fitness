package de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout.MotionSensor

class AccelerationSensor(
    context: Context
): MotionSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_ACCELEROMETER,
    sensorType = android.hardware.Sensor.TYPE_LINEAR_ACCELERATION
)

class ProximitySensor(
    context: Context
): MotionSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_PROXIMITY,
    sensorType = Sensor.TYPE_PROXIMITY
)