package com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.mainscreen

import com.gonzalez.blanchard.domain.base.models.WeatherBO

sealed class MainScreenStatus {
    object Idle : MainScreenStatus()
    object Loading : MainScreenStatus()
    class ShowWeather(val weatherBO: WeatherBO) : MainScreenStatus()
    class ShowError(val error: String) : MainScreenStatus()
}
