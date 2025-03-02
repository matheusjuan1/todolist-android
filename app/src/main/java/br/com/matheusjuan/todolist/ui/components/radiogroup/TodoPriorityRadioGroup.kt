package br.com.matheusjuan.todolist.ui.components.radiogroup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.ui.theme.Gray200
import br.com.matheusjuan.todolist.ui.theme.Gray500
import br.com.matheusjuan.todolist.ui.theme.Typography
import br.com.matheusjuan.todolist.ui.util.enums.Priority
import br.com.matheusjuan.todolist.ui.util.getPriorityInfo

@Composable
fun TodoPriorityRadioGroup(
    selectedPriority: Int,
    onPrioritySelected: (Int) -> Unit
) {
    val options = listOf(Priority.LOW.value, Priority.MEDIUM.value, Priority.HIGH.value)

    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        options.forEach { priority ->
            val (label, color) = priority.getPriorityInfo(context = context)

            val isSelected = priority == selectedPriority

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (isSelected) color.copy(alpha = 0.2f)
                        else Gray200
                    )
                    .clickable { onPrioritySelected(priority) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    style = if (isSelected) Typography.labelMedium else Typography.bodyMedium,
                    color = Gray500
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoPriorityRadioGroupPreview() {
    TodoPriorityRadioGroup(
        selectedPriority = Priority.LOW.value,
        onPrioritySelected = { }
    )
}

