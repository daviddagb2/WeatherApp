package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyForecastItem(
    @Json(name = "date") val date: String?,
    @Json(name = "date_epoch") val date_epoch: Long?,
    @Json(name = "astro") val astro: AstroItem?,
    @Json(name = "mintemp") val mintemp: Int?,
    @Json(name = "maxtemp") val maxtemp: Int?,
    @Json(name = "avgtemp") val avgtemp: Int?,
    @Json(name = "totalsnow") val totalsnow: Float?,
    @Json(name = "sunhour") val sunhour: Float?,
    @Json(name = "uv_index") val uv_index: Int?,
    @Json(name = "hourly") val hourly: List<HourlyForecastItem>?,
)
