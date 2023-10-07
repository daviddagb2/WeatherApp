package com.gonzalez.blanchard.domain.base.models

data class CurrentBO(
    val observationTime: String,
    val temperature: Int,
    val weatherCode: Int,
    val weatherIcons: List<String>,
    val weatherDescriptions: List<String>,
    val windSpeed: Int,
    val windDegree: Int,
    val windDir: String,
    val pressure: Int,
    val precip: Double,
    val humidity: Int,
    val cloudcover: Int,
    val feelslike: Int,
    val uvIndex: Int,
    val visibility: Int,
    val isDay: String,
)
