package br.com.matheusjuan.todolist.ui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.Gray600
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TodoTextField(
    initialText: String = "",
    label: String = "",
    enabled: Boolean = true,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(initialText) }
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged { isFocused = it.isFocused },
        value = text,
        enabled = enabled,
        textStyle = Typography.bodyMedium,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        label = {
            Text(
                text = label,
                style = if (isFocused) Typography.titleLarge.copy(fontSize = 12.sp) else Typography.labelMedium,
                color = if (isFocused) BlueBase else Gray600
            )
        }
    )
}

@Preview
@Composable
private fun TodoTextFieldPreview() {
    TodoTextField(
        initialText = "",
        label = "E-mail",
        onValueChange = { }
    )
}