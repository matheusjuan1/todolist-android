package br.com.matheusjuan.todolist.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.button.TodoButton
import br.com.matheusjuan.todolist.ui.components.task.TodoTaskForm
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TaskEditScreen(
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
            Box(modifier = Modifier.fillMaxWidth()) {
                TodoButton(
                    iconRes = R.drawable.ic_arrow_left,
                    onClick = onNavigateBack
                )
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(R.string.edit),
                    style = Typography.headlineLarge
                )
            }

            TodoTaskForm(
                modifier = Modifier.padding(top = 28.dp)
            )
        }
    }
}

@Preview
@Composable
private fun TaskEditScreenPreview() {
    TaskEditScreen(
        onNavigateBack = { },
        paddingValues = PaddingValues()
    )
}