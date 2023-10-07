package com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.gonzalez.blanchard.WheaTerApp.R
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.bottomnavigation.AppBottomNavigation
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items.ItemCityWeather

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val events: List<String> = listOf("Evento 1", "Evento 2", "Evento 3")
    val bottomNavController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    Icon(Icons.Default.Menu, contentDescription = null)
                },
                actions = {
                    Icon(Icons.Default.Notifications, contentDescription = null)
                },
            )
        },
        bottomBar = { AppBottomNavigation(bottomNavController = bottomNavController) },
    ) { paddingVal ->
        Column(
            modifier = Modifier.padding(paddingVal),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            ItemCityWeather()

            Spacer(modifier = Modifier.height(16.dp))

            // Lista de elementos
            LazyColumn {
                items(events) { item ->
                    ListItem(
                        icon = { /* TODO: Avatar o imagen del elemento */ },
                        text = { Text("Título del elemento") },
                        secondaryText = { Text("Descripción breve") },
                        trailing = {
                            Icon(Icons.Default.ArrowForward, contentDescription = null)
                        },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
