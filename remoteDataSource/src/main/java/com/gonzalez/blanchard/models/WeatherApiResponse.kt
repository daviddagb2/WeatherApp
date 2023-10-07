package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherApiResponse(
    @Json(name = "success") val success: Boolean,
    @Json(name = "request") val request: RequestResponse?,
    @Json(name = "location") val location: LocationResponse?,
    @Json(name = "current") val current: CurrentWeatherResponse?,
    @Json(name = "error") val error: ErrorResponse?,
)
