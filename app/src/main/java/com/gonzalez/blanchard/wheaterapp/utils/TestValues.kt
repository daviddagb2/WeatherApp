package com.gonzalez.blanchard.wheaterapp.utils

import com.gonzalez.blanchard.domain.base.models.CurrentBO
import com.gonzalez.blanchard.domain.base.models.ErrorBO
import com.gonzalez.blanchard.domain.base.models.ErrorDetailBO
import com.gonzalez.blanchard.domain.base.models.LocationBO
import com.gonzalez.blanchard.domain.base.models.RequestBO
import com.gonzalez.blanchard.domain.base.models.WeatherBO

object TestValues {
    val weatherBOTest = WeatherBO(
        success = true,
        request = RequestBO(
            type = "City",
            query = "Managua, Nicaragua",
            language = "en",
            unit = "m",
        ),
        location = LocationBO(
            name = "Managua",
            country = "Nicaragua",
            region = "Managua",
            lat = "12.151",
            lon = "-86.268",
            timezoneId = "America/Managua",
            localtime = "2023-10-07 13:15",
            localtimeEpoch = 1696684500,
            utcOffset = "-6.0",
        ),
        current = CurrentBO(
            observationTime = "06:15 PM",
            temperature = 28,
            weatherCode = 113,
            weatherIcons = listOf(
                "https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png",
            ),
            weatherDescriptions = listOf("Sunny"),
            windSpeed = 11,
            windDegree = 90,
            windDir = "E",
            pressure = 1012,
            precip = 0.0,
            humidity = 74,
            cloudcover = 0,
            feelslike = 30,
            uvIndex = 10,
            visibility = 10,
            isDay = "yes",
        ),
        error = ErrorBO(
            success = true,
            error = ErrorDetailBO(
                code = 0,
                type = "success",
                info = "Your API request was successful.",
            ),
        ),
    )
}
