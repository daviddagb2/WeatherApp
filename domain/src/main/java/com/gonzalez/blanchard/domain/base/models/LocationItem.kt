package com.gonzalez.blanchard.domain.base.models

data class LocationItem(
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val timezone: String
)