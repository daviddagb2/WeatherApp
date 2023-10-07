package com.gonzalez.blanchard.domain.base.models.inputs

data class CurrentWeatherInput(
    val city: String,
    val unit: String,
    val language: String,
)
