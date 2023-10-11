package com.gonzalez.blanchard.weatherapp.ui.views.compose.components.loaders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.utils.DeviceSizePreviews

@Composable
fun LoaderComponent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator() 
    }
}

@DeviceSizePreviews
@Composable
fun PreviewLoadingScreen() {
    LoaderComponent()
}
