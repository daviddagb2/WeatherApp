package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherForecastResponse(
    @Json(name = "request") val request: RequestItem?,
    @Json(name = "location") val location: LocationItem?,
    @Json(name = "current") val current: CurrentWeatherItem?,
    @Json(name = "forecast") val forecast: Map<String, DailyForecastItem>?,
)
