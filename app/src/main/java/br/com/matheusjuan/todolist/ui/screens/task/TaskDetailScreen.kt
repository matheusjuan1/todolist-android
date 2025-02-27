package br.com.matheusjuan.todolist.ui.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.data.model.mock.mockTasks
import br.com.matheusjuan.todolist.ui.components.button.TodoButton
import br.com.matheusjuan.todolist.ui.components.checkbox.TodoCheckbox
import br.com.matheusjuan.todolist.ui.theme.Gray100
import br.com.matheusjuan.todolist.ui.theme.Gray400
import br.com.matheusjuan.todolist.ui.theme.Gray600
import br.com.matheusjuan.todolist.ui.theme.GreenBase
import br.com.matheusjuan.todolist.ui.theme.RedBase
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TaskDetailScreen(
    modifier: Modifier = Modifier,
    task: Task,
    paddingValues: PaddingValues
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Gray100)
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 50.dp)
        ) {
            TodoButton(
                iconRes = R.drawable.ic_arrow_left,
                onClick = { }
            )

            TaskDetail(task = task)

            Spacer(modifier = Modifier.weight(1f))

            TaskButtons(
                onEdit = { },
                onDelete = { }
            )
        }
    }
}

@Composable
fun TaskDetail(
    task: Task
) {

    Column(
        modifier = Modifier.padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            TodoCheckbox(
                modifier = Modifier.scale(1.5f),
                checked = task.done,
                onCheckedChange = { }
            )

            Text(
                text = task.title,
                style = if (task.title.length > 25) Typography.headlineMedium
                else Typography.headlineLarge
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.description),
                style = Typography.headlineSmall
            )
            Text(
                text = task.description.ifBlank { stringResource(R.string.without_description) },
                style = Typography.bodyMedium,
                color = if (task.description.isBlank()) Gray400 else Gray600
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Text(
                    text = stringResource(R.string.start),
                    style = Typography.titleLarge
                )
                Text(
                    text = task.startAt,
                    style = Typography.bodySmall

                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.end),
                    style = Typography.titleLarge
                )
                Text(
                    text = task.endAt,
                    style = Typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun TaskButtons(
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        TodoButton(
            iconRes = R.drawable.ic_pencil,
            color = GreenBase,
            onClick = onEdit
        )

        Spacer(modifier = Modifier.width(30.dp))

        TodoButton(
            iconRes = R.drawable.ic_trash,
            color = RedBase,
            onClick = onDelete
        )
    }
}

@Preview
@Composable
private fun TaskDetailScreenPreview() {
    TaskDetailScreen(
        task = mockTasks.first(),
        paddingValues = PaddingValues()
    )
}