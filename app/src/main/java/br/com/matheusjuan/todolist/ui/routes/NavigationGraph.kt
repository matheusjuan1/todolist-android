package br.com.matheusjuan.todolist.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.ui.common.MainScreen
import br.com.matheusjuan.todolist.ui.common.TopBarScreen
import br.com.matheusjuan.todolist.ui.screens.home.HomeScreen
import br.com.matheusjuan.todolist.ui.screens.splash.SplashScreen
import br.com.matheusjuan.todolist.ui.screens.task.TaskDetailScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            MainScreen { paddingValues ->
                SplashScreen(
                    paddingValues = paddingValues,
                    onNavigateToNextScreen = {
                        navController.navigate(Home)
                    }
                )
            }
        }

        composable<Home> {
            TopBarScreen { paddingValues ->
                HomeScreen(
                    paddingValues = paddingValues,
                    onTaskClick = { selectedTask ->
                        navController.navigate(selectedTask)
                    }
                )
            }
        }

        composable<Task> {
            val selectedTask = it.toRoute<Task>()
            MainScreen { paddingValues ->
                TaskDetailScreen(
                    task = selectedTask,
                    paddingValues = paddingValues
                )
            }
        }
    }
}