package de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.uniks.codecamp.group_a.fitnessapp.feature_stationary_workout.Accelerometer
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {
    @Provides
    @Singleton
    fun provideAccelerometer(app: Application): Accelerometer {
        return Accelerometer(app)
    }

}