package com.gonzalez.blanchard.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponse(
    val code: Int,
    val type: String,
    val info: String,
)
