package com.app.basicnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Dashboard.route){
        composable(Dashboard.route){
            DashBoardScreen(navController)
        }

        composable(Details.route+"/{${Details.argOrderNo}}",arguments = listOf(
            navArgument(Details.argOrderNo) { type = NavType.IntType}
        )){
            DetailsScreen(it.arguments?.getInt(Details.argOrderNo))
        }
    }
}