package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyForecastItem(
    @Json(name = "time") val time: String?,
    @Json(name = "temperature") val temperature: Int?,
    @Json(name = "wind_speed") val wind_speed: Int?,
    @Json(name = "wind_degree") val wind_degree: Int?,
    @Json(name = "wind_dir") val wind_dir: String?,
    @Json(name = "weather_code") val weather_code: Int?,
    @Json(name = "weather_icons") val weather_icons: List<String>?,
    @Json(name = "weather_descriptions") val weather_descriptions: List<String>?,
    @Json(name = "precip") val precip: Float?,
    @Json(name = "humidity") val humidity: Int?,
    @Json(name = "visibility") val visibility: Int?,
    @Json(name = "pressure") val pressure: Int?,
    @Json(name = "cloudcover") val cloudcover: Int?,
    @Json(name = "heatindex") val heatindex: Int?,
    @Json(name = "dewpoint") val dewpoint: Int?,
    @Json(name = "windchill") val windchill: Int?,
    @Json(name = "windgust") val windgust: Int?,
    @Json(name = "feelslike") val feelslike: Int?,
    @Json(name = "chanceofrain") val chanceofrain: Int?,
    @Json(name = "chanceofremdry") val chanceofremdry: Int?,
    @Json(name = "chanceofwindy") val chanceofwindy: Int?,
    @Json(name = "chanceofovercast") val chanceofovercast: Int?,
    @Json(name = "chanceofsunshine") val chanceofsunshine: Int?,
    @Json(name = "chanceoffrost") val chanceoffrost: Int?,
    @Json(name = "chanceofhightemp") val chanceofhightemp: Int?,
    @Json(name = "chanceoffog") val chanceoffog: Int?,
    @Json(name = "chanceofsnow") val chanceofsnow: Int?,
    @Json(name = "chanceofthunder") val chanceofthunder: Int?,
    @Json(name = "uv_index") val uv_index: Int?,
)
