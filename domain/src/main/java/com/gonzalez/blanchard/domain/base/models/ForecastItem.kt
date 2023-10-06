package com.gonzalez.blanchard.domain.base.models

data class ForecastItem(
    val date: String,
    val dailyWeather: List<WeatherItem>,
    val hourlyWeather: List<WeatherItem>
)