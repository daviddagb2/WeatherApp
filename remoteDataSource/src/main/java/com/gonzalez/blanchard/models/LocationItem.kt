package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationItem(
    @Json(name = "name") val name: String?,
    @Json(name = "country") val country: String?,
    @Json(name = "region") val region: String?,
    @Json(name = "lat") val lat: String?,
    @Json(name = "lon") val lon: String?,
    @Json(name = "timezone_id") val timezone_id: String?,
    @Json(name = "localtime") val localtime: String?,
    @Json(name = "localtime_epoch") val localtime_epoch: Long?,
    @Json(name = "utc_offset") val utc_offset: String?,
)
