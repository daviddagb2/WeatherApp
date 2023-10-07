package com.gonzalez.blanchard.domain.base.models

data class LocationBO(
    val name: String,
    val country: String,
    val region: String,
    val lat: String,
    val lon: String,
    val timezoneId: String,
    val localtime: String,
    val localtimeEpoch: Long,
    val utcOffset: String,
)
