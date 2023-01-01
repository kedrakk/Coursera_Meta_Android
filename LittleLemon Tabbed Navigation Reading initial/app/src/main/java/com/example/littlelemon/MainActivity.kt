package com.example.littlelemon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navHostController:NavHostController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navHostController = navHostController) }) {
        Box(modifier = Modifier.padding(it)){
            NavHost(navController = navHostController, startDestination = Home.route){
                composable(Home.route){
                    HomeScreen()
                }
                composable(Location.route){
                    LocationScreen()
                }
                composable(Menu.route){
                    MenuScreen()
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation(navHostController: NavHostController) {
    val destinationList = listOf<Destinations>(
        Home,Location,Menu
    )
    val selectedIndex = rememberSaveable() {
        mutableStateOf(0)
    }
    BottomNavigation() {
        destinationList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = {
                        Text(text = destinations.title)
                },
                icon = {
                       Icon(imageVector = ImageVector.vectorResource(id = destinations.icon), contentDescription = destinations.title)
                },
                selected = index==selectedIndex.value,
                onClick = {
                    selectedIndex.value=index
                    navHostController.navigate(destinationList[index].route){
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                })
        }
    }
}