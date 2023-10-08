package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.bottomnavigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gonzalez.blanchard.WheaTerApp.R
import com.gonzalez.blanchard.wheaterapp.ui.theme.SelectedColor
import com.gonzalez.blanchard.wheaterapp.ui.theme.UnselectedColor

@Composable
fun AppBottomNavigation(
    bottomNavController: NavController,
) {
    var items: List<BottomNavItem> = mutableListOf<BottomNavItem>(
        BottomNavItem.Main,
        BottomNavItem.Cities,
        BottomNavItem.Map,
        BottomNavItem.Settings,
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
        modifier = Modifier.height(60.dp),
    ) {
        val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    IconElement(
                        item.iconResId,
                        item.titleResId,
                    )
                },
                label = {
                    BottonText(item.titleResId)
                },
                selectedContentColor = SelectedColor,
                unselectedContentColor = UnselectedColor,
                alwaysShowLabel = true,
                selected = currentRoute == item.screenRoute,
                enabled = true,
                onClick = {
                    bottomNavController.navigate(item.screenRoute) {
                        bottomNavController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            )
        }
    }
}

@Composable
fun IconElement(icon: Int, titleResId: Int) {
    Icon(
        painterResource(id = icon),
        contentDescription = stringResource(id = titleResId),
        modifier = Modifier
            .size(32.dp),
    )
}

@Composable
fun BottonText(titleResId: Int) {
    Text(
        text = stringResource(id = titleResId).uppercase(),
        fontSize = 7.sp,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.merriweather_sans_medium)),
        ),
    )
}

@Preview(name = "Bottom Navigation")
@Composable
fun PreviewBottonBar() {
    AppBottomNavigation(bottomNavController = NavController(LocalContext.current))
}
