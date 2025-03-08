package br.com.matheusjuan.todolist.ui.components.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.textfield.TodoTextField

@Composable
fun TodoTaskForm(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        TodoTextField(
            value = title,
            label = stringResource(R.string.title),
            maxChars = 50,
            onValueChange = { title = it }
        )

        TodoTextField(
            value = description,
            label = stringResource(R.string.description),
            maxChars = 255,
            onValueChange = { description = it }
        )
    }
}

@Preview
@Composable
private fun TodoTaskFormPreview() {
    TodoTaskForm()
}