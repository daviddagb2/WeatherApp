package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.WheaTerApp.R
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.utils.DeviceSizePreviews
import com.gonzalez.blanchard.wheaterapp.utils.TestValues

@Composable
fun WeatherForecastComponent(weatherBO: WeatherBO) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 0.dp, bottom = 1.dp),
       
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp),
        ) {
            Box(modifier = Modifier.weight(1f)) {
                IconAndTextRow(
                    iconResId = R.drawable.ic_city,
                    textItem = "City: ",
                    valueItem = weatherBO.location.name,
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                IconAndTextRow(
                    iconResId = R.drawable.ic_time,
                    textItem = "Observation Time: ",
                    valueItem = weatherBO.current.observationTime,
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(5.dp),
        ) {
            Box(modifier = Modifier.weight(1f)) {
                IconAndTextRow(
                    iconResId = R.drawable.ic_thermostat,
                    textItem = "Temperature: ",
                    valueItem = "${weatherBO.current.temperature}°C",
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                IconAndTextRow(
                    iconResId = R.drawable.ic_format,
                    textItem = "Description: ",
                    valueItem = weatherBO.current.weatherDescriptions.joinToString(),
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(5.dp),
        ) {
            Box(modifier = Modifier.weight(1f)) {
                IconAndTextRow(
                    iconResId = R.drawable.ic_wind,
                    textItem = "Wind Speed: ",
                    valueItem = "${weatherBO.current.windSpeed} km/h",
                )
            }

            Box(modifier = Modifier.weight(1f)) {
                IconAndTextRow(
                    iconResId = R.drawable.ic_wind_dir,
                    textItem = "Wind Direction: ",
                    valueItem = weatherBO.current.windDir,
                )
            }
        }
    }
}

@DeviceSizePreviews
@Composable
fun PreviewWeatherForecastComponent() {
    WeatherForecastComponent(TestValues.weatherBOTest)
}
