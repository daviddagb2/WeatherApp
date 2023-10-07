package com.gonzalez.blanchard.api // ktlint-disable filename

import com.gonzalez.blanchard.models.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/api/v1/weather/current")
    suspend fun getCurrentWeather(
        @Query("query") city: String,
        @Query("unit") unit: String = "m",
        // @Query("language") language: String = "en",
    ): Response<WeatherApiResponse>
}
