/*package com.example.app_2.core.navigation

import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.app_2.HomeScreen
import com.example.app_2.LoginScreen
import com.example.app_2.ui.theme.DetailScreen


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
}*/
