package com.gonzalez.blanchard.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestResponse(
    val type: String,
    val query: String,
    val language: String,
    val unit: String,
)
