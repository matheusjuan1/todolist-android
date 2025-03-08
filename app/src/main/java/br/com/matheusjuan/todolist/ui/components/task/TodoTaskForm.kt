package br.com.matheusjuan.todolist.ui.components.task

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.textfield.TodoTextField

@Composable
fun TodoTaskForm(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        TodoTextField(
            initialText = "",
            label = stringResource(R.string.title),
            onValueChange = { }
        )
    }
}

@Preview
@Composable
private fun TodoTaskFormPreview() {
    TodoTaskForm()
}