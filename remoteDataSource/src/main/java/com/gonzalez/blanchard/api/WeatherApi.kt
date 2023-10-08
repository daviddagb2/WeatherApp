package com.gonzalez.blanchard.api // ktlint-disable filename

import com.gonzalez.blanchard.models.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/current")
    suspend fun getCurrentWeather(
        @Query("query") city: String,
        @Query("units") units: String,
        // @Query("language") language: String = "en",
    ): Response<WeatherApiResponse>
}
