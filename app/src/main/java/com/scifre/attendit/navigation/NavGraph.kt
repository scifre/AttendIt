package com.scifre.attendit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scifre.attendit.screens.AddCourseScreen
import com.scifre.attendit.screens.HomeScreen

@Composable
fun navGraph(): NavHostController {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable(
            route = "home",
        ) {
            HomeScreen(navController)
        }
        composable(
            route = "addCourse"
        ) {
            AddCourseScreen()
        }
    }

    return navController
}