package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherItem(
    @Json(name = "observation_time") val observation_time: String?,
    @Json(name = "temperature") val temperature: Int?,
    @Json(name = "weather_code") val weather_code: Int?,
    @Json(name = "weather_icons") val weather_icons: List<String>?,
    @Json(name = "weather_descriptions") val weather_descriptions: List<String>?,
    @Json(name = "wind_speed") val wind_speed: Int?,
    @Json(name = "wind_degree") val wind_degree: Int?,
    @Json(name = "wind_dir") val wind_dir: String?,
    @Json(name = "pressure") val pressure: Int?,
    @Json(name = "precip") val precip: Float?,
    @Json(name = "humidity") val humidity: Int?,
    @Json(name = "cloudcover") val cloudcover: Int?,
    @Json(name = "feelslike") val feelslike: Int?,
    @Json(name = "uv_index") val uv_index: Int?,
    @Json(name = "visibility") val visibility: Int?,
)
