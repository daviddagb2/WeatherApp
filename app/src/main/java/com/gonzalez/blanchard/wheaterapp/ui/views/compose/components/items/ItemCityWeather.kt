package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.WheaTerApp.R

@Composable
fun ItemCityWeather() {
    Column(
        modifier = Modifier.fillMaxWidth().height(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, 
    ) {
        Text(text = "Managua")
        Text(text = "Chance of Rain")

        Box(modifier = Modifier.width(150.dp).height(150.dp)) {
            Image(
                painter = painterResource(id = R.mipmap.sunny_weather_icon),
                contentDescription = stringResource(R.string.app_name),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Text(text = "33 °C")
    }
}

@Preview
@Composable
fun PreviewItemCityWeather() {
    ItemCityWeather()
}
