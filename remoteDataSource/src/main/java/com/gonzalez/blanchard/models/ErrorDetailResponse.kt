package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorDetailResponse(
    @Json(name = "code") val code: Int?,
    @Json(name = "type") val type: String?,
    @Json(name = "info") val info: String?,
)
