package br.com.matheusjuan.todolist.ui.components.topbar


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.button.TodoProfileButton
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.Gray100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopBar(
    onProfileClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.shadow(elevation = 8.dp),
        title = {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.logo_todo),
                contentDescription = stringResource(R.string.app_logo),
            )
        },
        actions = {
            TodoProfileButton(
                modifier = Modifier.padding(end = 8.dp),
                text = "MJ",
                onClick = onProfileClick
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BlueBase,
            titleContentColor = Gray100
        )
    )
}

@Preview
@Composable
private fun TodoTopBarPreview() {
    TodoTopBar { }
}