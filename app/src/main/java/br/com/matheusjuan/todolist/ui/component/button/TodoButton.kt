package br.com.matheusjuan.todolist.ui.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TodoButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = BlueBase
        ),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = stringResource(R.string.button_icon)
                )
            }
            text?.let {
                Text(text = text, style = Typography.labelLarge)
            }
        }
    }
}

@Preview
@Composable
private fun TodoButtonPreview() {
    TodoButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.confirm)
    ) { }
}

@Preview
@Composable
private fun TodoButtonNoIconPreview() {

}

@Preview
@Composable
private fun TodoButtonNoTextPreview() {
    TodoButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.confirm)
    ) { }
}