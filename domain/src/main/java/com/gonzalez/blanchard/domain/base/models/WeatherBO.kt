package com.gonzalez.blanchard.domain.base.models

data class WeatherBO(
    val success: Boolean,
    val request: RequestBO,
    val location: LocationBO,
    val current: CurrentBO,
    val error: ErrorBO?,
)
