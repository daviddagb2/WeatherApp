package com.gonzalez.blanchard.data.di

import com.gonzalez.blanchard.data.repositories.WeatherRepository
import com.gonzalez.blanchard.domain.base.repository.IWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBindModule {
    
    @Binds
    abstract fun bindWeatherRepository(
        weatherRepository: WeatherRepository,
    ): IWeatherRepository
}
