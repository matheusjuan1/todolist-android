package br.com.matheusjuan.todolist.ui.components.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.Gray400
import br.com.matheusjuan.todolist.ui.theme.Gray600
import br.com.matheusjuan.todolist.ui.theme.Typography

enum class InputType(
    val keyboardType: KeyboardType,
    val visualTransformation: VisualTransformation
) {
    TEXT(KeyboardType.Text, VisualTransformation.None),
    NUMBER(KeyboardType.Number, VisualTransformation.None),
    EMAIL(KeyboardType.Email, VisualTransformation.None),
    PASSWORD(KeyboardType.Password, PasswordVisualTransformation())
}

@Composable
fun TodoTextField(
    value: String,
    label: String = "",
    enabled: Boolean = true,
    maxChars: Int? = null,
    maxLines: Int? = null,
    inputType: InputType = InputType.TEXT,
    onValueChange: (String) -> Unit
) {

    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged { isFocused = it.isFocused },
            value = value,
            enabled = enabled,
            maxLines = maxLines ?: 1,
            minLines = maxLines ?: 1,
            textStyle = Typography.bodyMedium,
            onValueChange = {
                if (maxChars == null || it.length <= maxChars) {
                    onValueChange(it)
                }
            },
            label = {
                Text(
                    text = label,
                    style = if (isFocused) Typography.titleLarge.copy(fontSize = 12.sp) else Typography.labelMedium,
                    color = if (isFocused) BlueBase else Gray600
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = inputType.keyboardType),
            visualTransformation =
            if (inputType == InputType.PASSWORD && passwordVisible) VisualTransformation.None
            else inputType.visualTransformation,
            trailingIcon = {
                if (inputType == InputType.PASSWORD) {
                    IconButton(
                        onClick = { passwordVisible = !passwordVisible }
                    ) {
                        Icon(
                            painter =
                            if (passwordVisible) painterResource(R.drawable.ic_eye)
                            else painterResource(R.drawable.ic_eye_off),
                            contentDescription =
                            if (passwordVisible) stringResource(R.string.hide_password)
                            else stringResource(R.string.show_password),
                            tint = Gray400
                        )
                    }
                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            horizontalArrangement = Arrangement.End
        ) {
            if (maxChars != null) {
                Text(
                    text = "${value.length}/${maxChars}",
                    style = Typography.bodySmall.copy(fontSize = 10.sp),
                    color = Gray400
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoTextFieldPreview() {
    TodoTextField(
        value = "",
        label = "E-mail",
        onValueChange = { }
    )
}

@Preview
@Composable
private fun TodoTextFieldCharsPreview() {
    TodoTextField(
        value = "",
        label = "E-mail",
        maxChars = 50,
        onValueChange = { }
    )
}