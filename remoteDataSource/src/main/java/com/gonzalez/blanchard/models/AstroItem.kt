package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AstroItem(
    @Json(name = "sunrise") val sunrise: String?,
    @Json(name = "sunset") val sunset: String?,
    @Json(name = "moonrise") val moonrise: String?,
    @Json(name = "moonset") val moonset: String?,
    @Json(name = "moon_phase") val moon_phase: String?,
    @Json(name = "moon_illumination") val moon_illumination: Int?,
)
