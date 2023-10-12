package com.gonzalez.blanchard.weatherapp.ui.views.compose.components.sections

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.texts.TitleText

@Composable
fun RequestPermissionScreen(onRequestPermissionClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TitleText("No se ha concedido el permiso de ubicación", textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onRequestPermissionClick) {
                Text(text = "Solicitar permiso")
            }
        }
    }
}

@Preview
@Composable
fun PreviewRequestPermissionScreen() {
    RequestPermissionScreen(onRequestPermissionClick = {})
}
