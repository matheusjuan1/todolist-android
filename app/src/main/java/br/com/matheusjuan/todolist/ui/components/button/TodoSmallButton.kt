package br.com.matheusjuan.todolist.ui.components.button

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TodoSmallButton(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = BlueBase,
    textColor: Color = Color.White,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .heightIn(min = 36.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        ),
        onClick = onClick
    ) {
        Text(
            text = text,
            style = Typography.titleLarge,
            color = textColor
        )
    }
}