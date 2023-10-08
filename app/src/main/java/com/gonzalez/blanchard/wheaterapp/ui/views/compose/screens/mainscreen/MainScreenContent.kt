package com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items.ItemCityWeather
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items.WeatherForecastComponent
import com.gonzalez.blanchard.wheaterapp.utils.TestValues

@Composable
fun MainScreenContent(
    paddingVal: PaddingValues = PaddingValues(0.dp),
    weatherBO: WeatherBO,
) {
    LazyColumn(
        modifier = Modifier.padding(paddingVal),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        item {
            ItemCityWeather(weatherBO = weatherBO)
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            WeatherForecastComponent(weatherBO = weatherBO)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenContent() {
    MainScreenContent(
        paddingVal = PaddingValues(16.dp),
        weatherBO = TestValues.weatherBOTest,
    )
}
