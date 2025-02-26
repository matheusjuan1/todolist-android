package br.com.matheusjuan.todolist.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(content: @Composable (PaddingValues) -> Unit) {
    Scaffold { paddingValues ->
        content(paddingValues)
    }
}