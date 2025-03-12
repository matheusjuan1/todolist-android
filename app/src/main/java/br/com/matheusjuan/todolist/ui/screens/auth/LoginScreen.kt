package br.com.matheusjuan.todolist.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.components.button.TodoButton
import br.com.matheusjuan.todolist.ui.components.button.TodoSmallButton
import br.com.matheusjuan.todolist.ui.components.textfield.InputType
import br.com.matheusjuan.todolist.ui.components.textfield.TodoTextField
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import br.com.matheusjuan.todolist.ui.theme.BlueLight
import br.com.matheusjuan.todolist.ui.theme.Gray200
import br.com.matheusjuan.todolist.ui.theme.Gray600
import br.com.matheusjuan.todolist.ui.theme.Typography

@Composable
fun LoginScreen(
    paddingValues: PaddingValues,
    onNavigateToRegister: () -> Unit,
    onLogin: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.logo_todo),
                tint = BlueBase,
                contentDescription = stringResource(R.string.app_logo)
            )
            Text(
                text = stringResource(R.string.task_manager),
                style = Typography.bodyLarge,
                color = BlueBase
            )
        }
        Row(
            modifier = Modifier
                .padding(horizontal = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TodoSmallButton(
                text = stringResource(R.string.login),
                color = BlueLight,
                onClick = { }
            )
            TodoSmallButton(
                text = stringResource(R.string.register),
                color = Gray200,
                textColor = Gray600,
                onClick = onNavigateToRegister
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)

        ) {
            TodoTextField(
                value = username,
                label = stringResource(R.string.username),
                onValueChange = { username = it }
            )
            TodoTextField(
                value = password,
                label = stringResource(R.string.password),
                inputType = InputType.PASSWORD,
                onValueChange = { password = it }
            )

            TodoButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                text = stringResource(R.string.login),
                onClick = onLogin
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        paddingValues = PaddingValues(),
        onNavigateToRegister = { },
        onLogin = { }
    )
}