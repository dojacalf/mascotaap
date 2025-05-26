package com.example.szapana.core.navigation

import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.szapana.HomeScreen
import com.example.szapana.LoginScreen
import com.example.szapana.ui.theme.DetailScreen


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen { name -> navController.navigate(Home(name=name)) }
        }
        composable<Home> { backStackEntry ->
            val detail:Home = backStackEntry.toRoute()
            HomeScreen(detail.name) { navController.navigate(Details) }
        }
        composable<Details> {
            DetailScreen{navController.navigateUp()}
        }
    }
}
