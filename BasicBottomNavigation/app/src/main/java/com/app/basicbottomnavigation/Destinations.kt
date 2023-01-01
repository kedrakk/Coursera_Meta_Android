package com.app.basicbottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
    val route: String
    val icon: ImageVector
    val title: String
}

object Home: Destinations{
    override val route: String
        get() = "Home"
    override val icon: ImageVector
        get() = Icons.Filled.Home
    override val title: String
        get() = "Home"
}

object Settings : Destinations{
    override val route: String
        get() = "Settings"
    override val icon: ImageVector
        get() = Icons.Filled.Settings
    override val title: String
        get() = "Settings"
}