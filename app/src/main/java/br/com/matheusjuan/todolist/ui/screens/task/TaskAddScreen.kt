package br.com.matheusjuan.todolist.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.button.TodoButton

@Composable
fun TaskAddScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    paddingValues: PaddingValues
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 50.dp)
        ) {
            TodoButton(
                iconRes = R.drawable.ic_arrow_left,
                onClick = onNavigateBack
            )
        }
    }
}

@Preview
@Composable
private fun TaskAddScreenPreview() {
    TaskAddScreen(
        onNavigateBack = {},
        paddingValues = PaddingValues()
    )
}