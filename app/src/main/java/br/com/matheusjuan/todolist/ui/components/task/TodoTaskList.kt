package br.com.matheusjuan.todolist.ui.components.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.data.model.mock.mockTasks
import br.com.matheusjuan.todolist.ui.theme.Gray300

@Composable
fun TodoTaskList(
    modifier: Modifier = Modifier,
    tasks: List<Task>,
    onTaskClick: (Task) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(items = tasks) { index, task ->
            Column {
                TodoTaskItem(
                    modifier = Modifier.fillMaxWidth(),
                    task = task,
                    onClick = onTaskClick,
                    onCheckedChange = { }
                )

                if (index < tasks.lastIndex) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = Gray300
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TodoTaskListPreview() {
    TodoTaskList(
        tasks = mockTasks
    ) { }
}