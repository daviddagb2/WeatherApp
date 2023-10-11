package com.gonzalez.blanchard.weatherapp.ui.views.compose.screens.mainscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.loaders.LoaderComponent

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    mainVM: MainScreenViewModel = hiltViewModel(),
) {
    val status by mainVM.status.collectAsState(initial = MainScreenStatus.Idle)

    when (status) {
        MainScreenStatus.Idle -> {
            mainVM.viewCreated()
            Text(text = "Idle")
        }
        is MainScreenStatus.ShowWeather -> {
            MainScreenContent(
                paddingVal = PaddingValues(0.dp),
                weatherBO = (status as MainScreenStatus.ShowWeather).weatherBO,
                onRefresh = { mainVM.refreshData() },
            )
        }
        MainScreenStatus.Loading -> {
            LoaderComponent()
        }
        is MainScreenStatus.ShowError -> {
            Text("Error")
        }
    }
}
