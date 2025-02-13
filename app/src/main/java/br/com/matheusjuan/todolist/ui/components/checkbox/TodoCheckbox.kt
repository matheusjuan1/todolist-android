package br.com.matheusjuan.todolist.ui.components.checkbox

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.Gray100
import br.com.matheusjuan.todolist.ui.theme.Gray600

@Composable
fun TodoCheckbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = BlueBase,
            uncheckedColor = Gray600,
            checkmarkColor = Gray100
        )
    )
}

@Preview
@Composable
private fun TodoCheckboxUncheckedPreview() {
    TodoCheckbox(checked = false) { }
}

@Preview
@Composable
private fun TodoCheckboxCheckedPreview() {
    TodoCheckbox(checked = true) { }
}