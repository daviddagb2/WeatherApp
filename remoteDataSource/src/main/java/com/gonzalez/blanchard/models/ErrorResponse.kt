package com.gonzalez.blanchard.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    @Json(name = "success") val success: Boolean?,
    @Json(name = "error") val error: ErrorDetailResponse?,
)
