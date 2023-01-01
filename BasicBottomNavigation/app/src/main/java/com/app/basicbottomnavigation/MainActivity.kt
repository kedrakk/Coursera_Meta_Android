package com.app.basicbottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.basicbottomnavigation.ui.theme.BasicBottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicBottomNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController: NavHostController = rememberNavController()
    Scaffold(bottomBar = { MyBottomNavigation(navHostController = navHostController) }) {
        Box(Modifier.padding(it)) {
            NavHost(navController = navHostController, startDestination = Home.route) {
                composable(Home.route) {
                    HomeScreen()
                }
                composable(Settings.route) {
                    SettingScreen()
                }
            }
        }
    }
}

@Composable
fun MyBottomNavigation(navHostController: NavHostController) {
    val destinationList = listOf<Destinations>(Home, Settings)
    var selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation {
        destinationList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                icon = {
                    Icon(imageVector = destinations.icon, contentDescription = destinations.title)
                },
                label = {
                    Text(text = destinations.title)
                },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navHostController.navigate(destinationList[index].route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                })
        }
    }
}