package br.com.matheusjuan.todolist.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.matheusjuan.todolist.ui.screens.home.HomeScreen
import br.com.matheusjuan.todolist.ui.screens.splash.SplashScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen()
        }

        composable<Home> {
            HomeScreen()
        }
    }
}