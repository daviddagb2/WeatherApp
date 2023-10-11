package com.gonzalez.blanchard.weatherapp.ui.views.compose.screens.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.domain.base.models.WeatherBO
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.items.ItemCityWeather
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.items.WeatherForecastComponent
import com.gonzalez.blanchard.weatherapp.utils.TestValues
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreenContent(
    paddingVal: PaddingValues = PaddingValues(0.dp),
    weatherBO: WeatherBO,
    onRefresh: () -> Unit = {},
) {
    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }

    fun refresh() = refreshScope.launch {
        refreshing = true
        onRefresh()
        refreshing = false
    }

    val state = rememberPullRefreshState(refreshing, ::refresh)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(state),
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

        PullRefreshIndicator(refreshing, state, Modifier.align(Alignment.TopCenter))
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
