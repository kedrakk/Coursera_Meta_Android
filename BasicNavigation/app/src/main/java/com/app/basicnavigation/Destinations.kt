package com.app.basicnavigation

interface Destinations {
    val route: String
}

object Dashboard:Destinations{
    override val route: String
        get() = "Home"
}

object Details:Destinations{
    const val argOrderNo = "orderNo"
    override val route: String
        get() = "Details"
}