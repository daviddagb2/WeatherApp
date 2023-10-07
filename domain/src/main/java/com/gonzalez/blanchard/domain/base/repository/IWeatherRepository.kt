package com.gonzalez.blanchard.domain.base.repository

import com.gonzalez.blanchard.domain.base.models.WeatherBO

interface IWeatherRepository {
    suspend fun getCurrentWeather(city: String, language: String = "en", unit: String = "m"): WeatherBO
}
