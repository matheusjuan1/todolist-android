package br.com.matheusjuan.todolist.ui.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.ui.theme.Gray300
import br.com.matheusjuan.todolist.ui.theme.Gray600
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun TodoProfileButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    sizeType: Int = 1, // 1 = Small, 2 = Large
    onClick: () -> Unit
) {
    val size = if (sizeType == 1) 34.dp else 64.dp

    Button(
        modifier = modifier.size(size),
        onClick = onClick,
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Gray300
        )
    ) {
        Text(
            text = text ?: "?",
            style = if (sizeType == 1) Typography.headlineSmall else Typography.headlineLarge,
            color = Gray600
        )
    }
}

@Preview
@Composable
private fun TodoProfileButtonSmallPreview() {
    TodoProfileButton(
        text = "MJ",
    ) { }
}

@Preview
@Composable
private fun TodoPrfileButtonLargePreview() {
    TodoProfileButton(
        text = "MJ",
        sizeType = 2
    ) { }
}