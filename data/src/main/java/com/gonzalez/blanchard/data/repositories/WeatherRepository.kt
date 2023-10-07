package com.gonzalez.blanchard.data.repositories

import com.gonzalez.blanchard.data.mappers.responses.toWeatherItem
import com.gonzalez.blanchard.datasources.WeatherRemoteDataSource
import com.gonzalez.blanchard.domain.base.models.WeatherItem
import com.gonzalez.blanchard.domain.base.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource,
) : IWeatherRepository {

    override suspend fun getCurrentWeather(city: String, unit: String, language: String): WeatherItem {
        val weatherApiResponse = weatherRemoteDataSource.getCurrentWeather(city, language, unit)
        return weatherApiResponse.toWeatherItem()
    }
}
