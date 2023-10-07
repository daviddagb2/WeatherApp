package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationResponse(
    @Json(name = "name") val name: String?,
    @Json(name = "country") val country: String?,
    @Json(name = "region") val region: String?,
    @Json(name = "lat") val latitude: String?,
    @Json(name = "lon") val longitude: String?,
    @Json(name = "timezone_id") val timezoneId: String?,
    @Json(name = "localtime") val localtime: String?,
    @Json(name = "localtime_epoch") val localtimeEpoch: Long?,
    @Json(name = "utc_offset") val utcOffset: String?,
)
