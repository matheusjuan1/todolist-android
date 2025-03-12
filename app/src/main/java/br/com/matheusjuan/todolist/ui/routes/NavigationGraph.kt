package br.com.matheusjuan.todolist.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.data.model.TaskEdit
import br.com.matheusjuan.todolist.ui.common.MainScreen
import br.com.matheusjuan.todolist.ui.common.TopBarScreen
import br.com.matheusjuan.todolist.ui.screens.auth.LoginScreen
import br.com.matheusjuan.todolist.ui.screens.auth.RegisterScreen
import br.com.matheusjuan.todolist.ui.screens.home.HomeScreen
import br.com.matheusjuan.todolist.ui.screens.splash.SplashScreen
import br.com.matheusjuan.todolist.ui.screens.task.TaskAddScreen
import br.com.matheusjuan.todolist.ui.screens.task.TaskDetailScreen
import br.com.matheusjuan.todolist.ui.screens.task.TaskEditScreen

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
                        navController.navigate(Login) {
                            popUpTo<Splash> {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        composable<Login> {
            MainScreen { paddingValues ->
                LoginScreen(
                    paddingValues = paddingValues,
                    onNavigateToRegister = {
                        navController.navigate(Register) {
                            popUpTo<Login> {
                                inclusive = true
                            }
                        }
                    },
                    onLogin = {
                        navController.navigate(Home) {
                            popUpTo<Login> {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        composable<Register> {
            MainScreen { paddingValues ->
                RegisterScreen(
                    paddingValues = paddingValues,
                    onNavigateToLogin = {
                        navController.navigate(Login) {
                            popUpTo<Register> {
                                inclusive = true
                            }
                        }
                    },
                    onRegister = {
                        navController.navigate(Home) {
                            popUpTo<Register> {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }

        composable<Home> {
            TopBarScreen(
                onFABClick = {
                    navController.navigate(TaskAdd)
                }
            ) { paddingValues ->
                HomeScreen(
                    paddingValues = paddingValues,
                    onNavigateToDetail = { selectedTask ->
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
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onNavigateToEdit = { taskEdit ->
                        navController.navigate(taskEdit)
                    },
                    paddingValues = paddingValues
                )
            }
        }

        composable<TaskAdd> {
            MainScreen { paddingValues ->
                TaskAddScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    paddingValues = paddingValues
                )
            }
        }

        composable<TaskEdit> {
            MainScreen { paddingValues ->
                TaskEditScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    paddingValues = paddingValues
                )
            }
        }
    }
}