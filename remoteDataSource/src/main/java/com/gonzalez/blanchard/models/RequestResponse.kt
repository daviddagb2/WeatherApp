package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestResponse(
    @Json(name = "type") val type: String?,
    @Json(name = "query") val query: String?,
    @Json(name = "language") val language: String?,
    @Json(name = "unit") val unit: String?,
)
