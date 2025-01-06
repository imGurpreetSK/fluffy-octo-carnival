package com.gurpreetsk

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.gurpreetsk.navigation.HomeScreenNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreenNavigation()
    }
}