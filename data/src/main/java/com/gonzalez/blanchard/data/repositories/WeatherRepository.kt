package com.gonzalez.blanchard.data.repositories

import com.gonzalez.blanchard.data.mappers.responses.toWeatherItem
import com.gonzalez.blanchard.datasources.WeatherRemoteDataSource
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.domain.base.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
) : IWeatherRepository {

    override suspend fun getCurrentWeather(city: String, unit: String, language: String): WeatherBO {
        val weatherApiResponse = weatherRemoteDataSource.getCurrentWeather(city, language, unit)
        return weatherApiResponse.toWeatherItem()
    }
}
