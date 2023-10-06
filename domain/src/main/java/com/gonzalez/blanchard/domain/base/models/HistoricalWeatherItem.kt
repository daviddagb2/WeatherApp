package com.gonzalez.blanchard.domain.base.models

data class HistoricalWeatherItem(
    val date: String,
    val pastWeather: WeatherItem
)