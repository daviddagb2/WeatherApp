package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.bottomnavigation

import com.gonzalez.blanchard.WheaTerApp.R

sealed class BottomNavItem(val titleResId: Int, val iconResId: Int, val screenRoute: String) {
    object Main : BottomNavItem(R.string.main, R.drawable.ic_weather, "main")
    object Cities : BottomNavItem(R.string.cities, R.drawable.ic_cities, "cities")
    object Map : BottomNavItem(R.string.map, R.drawable.ic_map, "map")
    object Settings : BottomNavItem(R.string.settings, R.drawable.ic_settings, "settings")
}
