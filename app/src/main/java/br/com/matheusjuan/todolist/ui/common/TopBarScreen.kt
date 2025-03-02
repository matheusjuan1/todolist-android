package br.com.matheusjuan.todolist.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import br.com.matheusjuan.todolist.ui.components.button.TodoFloatingActionButton
import br.com.matheusjuan.todolist.ui.components.topbar.TodoTopBar

@Composable
fun TopBarScreen(
    onFABClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            TodoTopBar { }
        },
        floatingActionButton = {
            TodoFloatingActionButton(
                onClick = onFABClick
            )
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}