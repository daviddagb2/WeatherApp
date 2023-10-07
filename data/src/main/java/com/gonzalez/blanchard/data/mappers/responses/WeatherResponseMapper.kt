package com.gonzalez.blanchard.data.mappers.responses

import com.gonzalez.blanchard.domain.base.models.WeatherItem
import com.gonzalez.blanchard.models.WeatherApiResponse

fun WeatherApiResponse.toWeatherItem(): WeatherItem {
    val currentWeather = this.current
    return WeatherItem(
        temperature = currentWeather?.temperature?.toDouble() ?: 0.0,
        condition = currentWeather?.weather_descriptions?.firstOrNull() ?: "",
        iconUrl = currentWeather?.weather_icons?.firstOrNull() ?: "",
        windSpeed = currentWeather?.wind_speed?.toDouble() ?: 0.0,
        windDirection = currentWeather?.wind_dir ?: "",
        humidity = currentWeather?.humidity ?: 0,
        pressure = currentWeather?.pressure?.toDouble() ?: 0.0,
        feelsLike = currentWeather?.feelslike?.toDouble() ?: 0.0,
        uvIndex = currentWeather?.uv_index ?: 0,
        visibility = currentWeather?.visibility?.toDouble() ?: 0.0,
    )
}
