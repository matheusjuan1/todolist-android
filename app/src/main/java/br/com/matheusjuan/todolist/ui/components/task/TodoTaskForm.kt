package br.com.matheusjuan.todolist.ui.components.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.radiogroup.TodoPriorityRadioGroup
import br.com.matheusjuan.todolist.ui.components.textfield.TodoTextField
import br.com.matheusjuan.todolist.ui.screens.task.state.TaskFormState
import br.com.matheusjuan.todolist.ui.theme.Typography
import br.com.matheusjuan.todolist.ui.util.enums.Priority

@Composable
fun TodoTaskForm(
    modifier: Modifier = Modifier,
    state: TaskFormState
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        TodoTextField(
            value = state.title,
            label = stringResource(R.string.title),
            maxChars = 50,
            onValueChange = state.onTitleChange
        )

        TodoTextField(
            value = state.description,
            label = stringResource(R.string.description),
            maxChars = 255,
            maxLines = 4,
            onValueChange = state.onDescriptionChange
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.priority),
                style = Typography.labelMedium
            )
            TodoPriorityRadioGroup(
                selectedPriority = state.priority,
                onPrioritySelected = state.onPriorityChange
            )
        }
    }
}

@Preview
@Composable
private fun TodoTaskFormPreview() {
    TodoTaskForm(
        state = TaskFormState(
            title = "",
            onTitleChange = { },
            description = "",
            onDescriptionChange = { },
            priority = Priority.LOW.value,
            onPriorityChange = { }
        )
    )
}