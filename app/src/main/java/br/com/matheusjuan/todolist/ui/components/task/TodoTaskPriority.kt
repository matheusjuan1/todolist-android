package br.com.matheusjuan.todolist.ui.components.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.ui.theme.Gray300
import br.com.matheusjuan.todolist.ui.util.enums.Priority

@Composable
fun TodoTaskPriority(
    modifier: Modifier = Modifier,
    priority: Int
) {
    val priorityColor = Priority.fromValue(priority).color

    val colors = when (priority) {
        Priority.LOW.value -> listOf(priorityColor, Gray300, Gray300)
        Priority.MEDIUM.value -> listOf(priorityColor, priorityColor, Gray300)
        Priority.HIGH.value -> listOf(priorityColor, priorityColor, priorityColor)
        else -> listOf(priorityColor, Gray300, Gray300)
    }

    val heights = listOf(10.dp, 13.dp, 16.dp)

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        colors.forEachIndexed { index, color ->
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(heights[index])
                    .background(
                        color = color,
                        shape = RoundedCornerShape(2.dp)
                    )
            )
        }
    }
}

@Preview
@Composable
private fun TodoTaskPriorityLowPreview() {
    TodoTaskPriority(priority = 1)
}

@Preview
@Composable
private fun TodoTaskPriorityMediumPreview() {
    TodoTaskPriority(priority = 2)
}

@Preview
@Composable
private fun TodoTaskPriorityHighPreview() {
    TodoTaskPriority(priority = 3)
}