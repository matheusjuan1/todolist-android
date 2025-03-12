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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.button.TodoButton
import br.com.matheusjuan.todolist.ui.components.task.TodoTaskForm
import br.com.matheusjuan.todolist.ui.screens.task.state.TaskFormState
import br.com.matheusjuan.todolist.ui.theme.Typography
import br.com.matheusjuan.todolist.ui.util.enums.Priority

@Composable
fun TaskAddScreen(
    onNavigateBack: () -> Unit,
    paddingValues: PaddingValues
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var priority by remember { mutableIntStateOf(Priority.LOW.value) }

    val formState = TaskFormState(
        title = title,
        onTitleChange = { title = it },
        description = description,
        onDescriptionChange = { description = it },
        priority = priority,
        onPriorityChange = { priority = it }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 12.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                TodoButton(
                    iconRes = R.drawable.ic_arrow_left,
                    onClick = onNavigateBack
                )
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(R.string.add),
                    style = Typography.headlineLarge
                )
            }

            TodoTaskForm(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 22.dp),
                state = formState
            )

            TodoButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.add),
                onClick = { }
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