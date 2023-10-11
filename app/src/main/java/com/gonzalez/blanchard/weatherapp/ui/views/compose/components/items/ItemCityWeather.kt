package com.gonzalez.blanchard.weatherapp.ui.views.compose.components.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.texts.SubTitleText
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.texts.TitleText
import com.gonzalez.blanchard.weatherapp.utils.TestValues

@Composable
fun ItemCityWeather(weatherBO: WeatherBO) {
    Column(
        modifier = Modifier.fillMaxWidth().heightIn(250.dp).padding(top = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, 
    ) {
        TitleText(value = weatherBO.location.name)

        SubTitleText(weatherBO.location.country)

        Box(modifier = Modifier.padding(20.dp).width(100.dp).height(100.dp)) {
            if (weatherBO.current.weatherIcons.isNotEmpty()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(weatherBO.current.weatherIcons.first())
                        .crossfade(true)
                        .build(),
                    contentDescription = weatherBO.location.name,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }

        TitleText(value = "${weatherBO.current.temperature} °C")
    }
}

@Preview
@Composable
fun PreviewItemCityWeather() {
    ItemCityWeather(TestValues.weatherBOTest)
}
