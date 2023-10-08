package com.gonzalez.blanchard.datasources

import com.gonzalez.blanchard.api.WeatherApi
import com.gonzalez.blanchard.extensions.parseResponse
import com.gonzalez.blanchard.models.WeatherApiResponse
import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val weatherApi: WeatherApi,
) {
    suspend fun getCurrentWeather(city: String, units: String, language: String): WeatherApiResponse {
        return weatherApi.getCurrentWeather(city, units).parseResponse()
    }
}
