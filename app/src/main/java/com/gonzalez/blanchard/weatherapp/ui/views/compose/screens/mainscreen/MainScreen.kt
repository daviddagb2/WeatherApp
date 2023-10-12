package com.gonzalez.blanchard.weatherapp.ui.views.compose.screens.mainscreen

import android.Manifest
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.loaders.LoaderComponent
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.sections.RequestPermissionScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalMaterialApi::class, ExperimentalPermissionsApi::class)
@Composable
fun MainScreen() {
    // GPS permission state
    val locationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_FINE_LOCATION,
    )

    when {
        locationPermissionState.status.isGranted -> {
            MainScreenWithPermission(locationPermissionState = locationPermissionState)
        }
        locationPermissionState.status.shouldShowRationale -> {
            RequestPermissionScreen {
                locationPermissionState.launchPermissionRequest()
            }
        }
        else -> {
            RequestPermissionScreen {
                locationPermissionState.launchPermissionRequest()
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreenWithPermission(
    locationPermissionState: PermissionState,
    mainVM: MainScreenViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val status by mainVM.status.collectAsState(initial = MainScreenStatus.Idle)

    when (status) {
        MainScreenStatus.Idle -> {
            mainVM.fetchLocation(context)
        }
        is MainScreenStatus.ShowWeather -> {
            MainScreenContent(
                paddingVal = PaddingValues(0.dp),
                weatherBO = (status as MainScreenStatus.ShowWeather).weatherBO,
                onRefresh = { mainVM.refreshData(context) },
            )
        }
        MainScreenStatus.Loading -> {
            LoaderComponent()
        }
        MainScreenStatus.PermissionRequired -> {
            RequestPermissionScreen {
                locationPermissionState.launchPermissionRequest()
            }
        }
        is MainScreenStatus.ShowError -> {
            Text("Error")
        }
    }
}
