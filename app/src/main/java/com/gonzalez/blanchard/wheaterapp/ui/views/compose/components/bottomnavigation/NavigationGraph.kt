package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.bottomnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.cities.CitiesScreen
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.mainscreen.MainScreen
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.map.MapScreen
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.screens.settings.SettingsScreen

@Composable
fun NavigationGraphContent(bottomNavController: NavHostController, modifier: Modifier) {
    Column(modifier = modifier) {
        NavigationGraph(bottomNavController)
    }
}

@Composable
fun NavigationGraph(bottomNavController: NavHostController) {
    NavHost(
        bottomNavController,
        startDestination = BottomNavItem.Main.screenRoute,
    ) {
        composable(BottomNavItem.Main.screenRoute) {
            MainScreen()
        }
        composable(BottomNavItem.Cities.screenRoute) {
            CitiesScreen()
        }
        composable(BottomNavItem.Map.screenRoute) {
            MapScreen()
        }
        composable(BottomNavItem.Settings.screenRoute) {
            SettingsScreen()
        }
    }
}
