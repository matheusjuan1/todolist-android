package br.com.matheusjuan.todolist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.matheusjuan.todolist.routes.AppNavigation
import br.com.matheusjuan.todolist.routes.Home
import br.com.matheusjuan.todolist.ui.components.topbar.TodoTopBar
import br.com.matheusjuan.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route

                // Define se o TopBar deve ser mostrado
                val showTopBar = when (currentRoute) {
                    Home.toString() -> true
                    else -> false
                }

                Scaffold(
                    topBar = {
                        if (showTopBar) {
                            TodoTopBar { }
                        }
                    }
                ) { paddingValues ->
                    AppNavigation(
                        navController = navController,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }
}