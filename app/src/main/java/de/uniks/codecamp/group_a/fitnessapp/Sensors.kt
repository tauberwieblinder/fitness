package de.uniks.codecamp.group_a.fitnessapp

import android.content.Context
import android.content.pm.PackageManager

class AccelerationSensor(
    context: Context
): MotionSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_ACCELEROMETER,
    sensorType = android.hardware.Sensor.TYPE_ACCELEROMETER
)