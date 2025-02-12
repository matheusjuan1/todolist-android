package br.com.matheusjuan.todolist.ui.component.task

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.data.model.mock.mockTasks
import br.com.matheusjuan.todolist.ui.component.checkbox.TodoCheckbox
import br.com.matheusjuan.todolist.ui.theme.Gray100
import br.com.matheusjuan.todolist.ui.theme.Gray300
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TodoTaskItem(
    modifier: Modifier = Modifier,
    task: Task,
    onClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .clickable { onClick() }
            .background(if (task.done) Gray300 else Gray100)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        TodoCheckbox(
            modifier = Modifier.scale(1.5f),
            checked = task.done,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = task.title,
            style = Typography.labelMedium
        )
    }
}

@Preview
@Composable
private fun TodoTaskItemPreview() {
    TodoTaskItem(
        modifier = Modifier.fillMaxWidth(),
        task = mockTasks.first(),
        onClick = { },
        onCheckedChange = { }
    )
}

@Preview
@Composable
private fun TodoTaskItemDonePreview() {
    TodoTaskItem(
        modifier = Modifier.fillMaxWidth(),
        task = mockTasks[2],
        onClick = { },
        onCheckedChange = { }
    )
}
