package com.example.littlelemon

interface Destinations {
    val route : String
}

object Home : Destinations{
    override val route: String
        get() = "Home"
}

object Menu : Destinations{
    override val route: String
        get() = "Menu"
}