package com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.bottomnavigation.AppBottomNavigation
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.bottomnavigation.NavigationGraphContent

@Composable
fun ScaffoldScreen() {
    val bottomNavController = rememberNavController()
    
    Scaffold(
        topBar = {
           /* TopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    Icon(Icons.Default.Menu, contentDescription = null)
                },
                actions = {
                    Icon(Icons.Default.Notifications, contentDescription = null)
                },
            )*/
        },
        bottomBar = { AppBottomNavigation(bottomNavController = bottomNavController) },
    ) { paddingVal ->
        Box(
            modifier = Modifier
                .padding(paddingVal)
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
        ) {
            NavigationGraphContent(
                bottomNavController = bottomNavController,
                Modifier
                    .fillMaxWidth(),
            )
        }
    }
}
