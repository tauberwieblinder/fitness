package de.uniks.codecamp.group_a.fitnessapp

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {
    @Provides
    fun provideAccelerationSensor(app: Application): AccelerationSensor {
        return AccelerationSensor(app)
    }
}