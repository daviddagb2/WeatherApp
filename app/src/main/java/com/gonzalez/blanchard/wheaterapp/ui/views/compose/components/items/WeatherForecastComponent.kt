package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gonzalez.blanchard.domain.base.models.WeatherBO

@Composable
fun WeatherForecastComponent(weatherBO: WeatherBO) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Observation Time: ${weatherBO.current.observationTime}")
        Text(text = "Temperature: ${ weatherBO.current.temperature }°C")
        Text(text = "Description: ${ weatherBO.current.weatherDescriptions.joinToString()}")
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(weatherBO.current.weatherIcons.first())
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.size(64.dp),
        )

        Text(text = "Wind Speed: ${ weatherBO.current.windSpeed } km/h")
        Text(text = "Wind Direction: ${ weatherBO.current.windDir }")
    }
}
