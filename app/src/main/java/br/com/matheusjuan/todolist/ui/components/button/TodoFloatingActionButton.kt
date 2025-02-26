package br.com.matheusjuan.todolist.ui.components.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.theme.BlueBase

@Composable
fun TodoFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(
        containerColor = BlueBase,
        onClick = onClick
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add)
        )
    }
}

@Preview
@Composable
private fun TodoFloatingActionButtonPreview() {
    TodoFloatingActionButton {  }
}