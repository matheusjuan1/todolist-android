package br.com.matheusjuan.todolist.ui.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.theme.Gray300
import br.com.matheusjuan.todolist.ui.theme.Gray600
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TodoCircleButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconRes: Int? = null,
    text: String? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.size(30.dp),
        onClick = onClick,
        shape = CircleShape,
        contentPadding = PaddingValues(if (text == null && iconRes != null) 6.dp else 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Gray300
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = stringResource(id = R.string.button_icon),
                    tint = Gray600
                )
            }
            text?.let {
                Text(
                    text = text,
                    style = Typography.headlineLarge,
                    color = Gray600
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoCircleButtonIconPreview() {
    TodoCircleButton(
        iconRes = R.drawable.ic_trash
    ) { }
}

@Preview
@Composable
private fun TodoCircleButtonTextPreview() {
    TodoCircleButton(
        text = "+"
    ) { }
}