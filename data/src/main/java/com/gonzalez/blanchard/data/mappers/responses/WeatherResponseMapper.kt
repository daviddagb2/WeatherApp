package com.gonzalez.blanchard.data.mappers.responses

import com.gonzalez.blanchard.domain.base.models.CurrentBO
import com.gonzalez.blanchard.domain.base.models.LocationBO
import com.gonzalez.blanchard.domain.base.models.RequestBO
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.models.WeatherApiResponse

fun WeatherApiResponse.toWeatherItem(): WeatherBO {
    val currentWeather = this.current
    return WeatherBO(
        success = this.success ?: true,
        request = this.request?.toRequestBO() ?: RequestBO(
            type = "",
            query = "",
            language = "",
            unit = "",
        ), 
        location = this.location?.toLocationBO() ?: LocationBO(
            name = "",
            country = "",
            region = "",
            lat = "",
            lon = "",
            timezoneId = "",
            localtime = "",
            localtimeEpoch = 0,
            utcOffset = "",
        ),
        current = this.current?.toCurrentBO() ?: CurrentBO(
            observationTime = "",
            temperature = 0,
            weatherCode = 0,
            weatherIcons = listOf(),
            weatherDescriptions = listOf(),
            windSpeed = 0,
            windDegree = 0,
            windDir = "",
            pressure = 0,
            precip = 0.0,
            humidity = 0,
            cloudcover = 0,
            feelslike = 0,
            uvIndex = 0,
            visibility = 0,
            isDay = "",
        ),
        error = this.error?.toErrorBO(),
    )
}
