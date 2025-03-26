package com.gurpreetsk.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gurpreetsk.discovery.DiscoveryFeedScreen
import com.gurpreetsk.feature.screen1.Screen1
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreenNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        NavigationHost(navController = navController)
    }
}

@Composable
private fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Discovery,
        Screen.Screen1,
        Screen.Screen2,
        Screen.Screen3
    )

    BottomNavigation {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        screen.icon,
                        contentDescription = screen.label,
                        tint = if (currentRoute == screen.route) Color.Blue else Color.Gray.copy(
                            alpha = 0.6f
                        )
                    )
                },
                label = {
                    Text(
                        text = screen.label,
                        color = if (currentRoute == screen.route) Color.Blue else Color.Gray.copy(
                            alpha = 0.6f
                        )
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Screen1.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

@Composable
private fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Discovery.route) {
        composable(Screen.Discovery.route) {
            DiscoveryFeedScreen()
        }
        composable(Screen.Screen1.route) {
            Screen1()
        }
        composable(Screen.Screen2.route) {
            Screen1()
        }
        composable(Screen.Screen3.route) {
            Screen1()
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreenNavigation() {
    MaterialTheme {
        HomeScreenNavigation()
    }
}
