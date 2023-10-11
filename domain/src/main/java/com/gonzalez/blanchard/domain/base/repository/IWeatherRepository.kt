package com.gonzalez.blanchard.domain.base.repository

import com.gonzalez.blanchard.domain.base.models.WeatherBO

interface IWeatherRepository {
    suspend fun getCurrentWeather(city: String, unit: String = "m", language: String = "en"): WeatherBO
}
