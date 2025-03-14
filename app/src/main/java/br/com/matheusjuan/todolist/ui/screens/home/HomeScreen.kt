package br.com.matheusjuan.todolist.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.data.model.mock.mockTasks
import br.com.matheusjuan.todolist.ui.components.button.TodoCircleButton
import br.com.matheusjuan.todolist.ui.components.task.TodoTaskList
import br.com.matheusjuan.todolist.ui.theme.Gray400
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    onNavigateToDetail: (Task) -> Unit
) {

    val tasks: List<Task> = mockTasks

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = Color.White)
    ) {
        Column {
            HeaderList(
                onPreviousDay = { },
                onNextDay = { },
                onSearch = { },
                onReload = { },
                onFilter = { }
            )
            if (tasks.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        text = "Você não possui tarefas para o dia de hoje",
                        style = Typography.labelMedium,
                        color = Gray400,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
            TodoTaskList(
                modifier = Modifier.padding(bottom = 12.dp),
                tasks = tasks,
                onTaskClick = { selectedTask ->
                    onNavigateToDetail(selectedTask)
                }
            )
        }
        }
    }
}

@Composable
fun HeaderList(
    onPreviousDay: () -> Unit,
    onNextDay: () -> Unit,
    onSearch: () -> Unit,
    onReload: () -> Unit,
    onFilter: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TodoCircleButton(
                iconRes = R.drawable.ic_arrow_left,
                onClick = onPreviousDay
            )
            Text(
                text = "Hoje",
                style = Typography.headlineSmall
            )
            TodoCircleButton(
                iconRes = R.drawable.ic_arrow_right,
                onClick = onNextDay
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TodoCircleButton(
                iconRes = R.drawable.ic_search,
                enabled = false,
                onClick = onSearch
            )
            TodoCircleButton(
                iconRes = R.drawable.ic_reload,
                enabled = false,
                onClick = onReload
            )
            TodoCircleButton(
                iconRes = R.drawable.ic_filter,
                enabled = false,
                onClick = onFilter
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenListPreview() {
    HomeScreen(
        paddingValues = PaddingValues(),
        onNavigateToDetail = { }
    )
}