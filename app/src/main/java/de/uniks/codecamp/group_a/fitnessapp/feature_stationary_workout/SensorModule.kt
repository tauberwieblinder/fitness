package de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout.AccelerationSensor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {
    @Provides
    @Singleton
    fun provideAccelerationSensor(app: Application): AccelerationSensor {
        return AccelerationSensor(app)
    }

}