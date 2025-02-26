package br.com.matheusjuan.todolist.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import br.com.matheusjuan.todolist.ui.components.button.TodoFloatingActionButton
import br.com.matheusjuan.todolist.ui.components.topbar.TodoTopBar

@Composable
fun TopBarScreen(
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            TodoTopBar { }
        },
        floatingActionButton = {
            TodoFloatingActionButton { }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}