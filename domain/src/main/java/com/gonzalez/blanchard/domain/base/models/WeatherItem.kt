package com.gonzalez.blanchard.domain.base.models

data class WeatherItem(
    val temperature: Double,
    val condition: String,
    val iconUrl: String,
    val windSpeed: Double,
    val windDirection: String,
    val humidity: Int,
    val pressure: Double,
    val feelsLike: Double,
    val uvIndex: Int,
    val visibility: Double
)