package br.com.matheusjuan.todolist.ui.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun RegisterScreen(
    paddingValues: PaddingValues,
    onNavigateToLogin: () -> Unit,
    onRegister: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
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
                color = Gray200,
                textColor = Gray600,
                onClick = onNavigateToLogin
            )
            TodoSmallButton(
                text = stringResource(R.string.register),
                color = BlueLight,
                onClick = { }
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 10.dp, start = 20.dp, end = 20.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            TodoTextField(
                value = name,
                label = stringResource(R.string.name),
                onValueChange = { name = it }
            )

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

            TodoTextField(
                value = confirmPassword,
                label = stringResource(R.string.confirm_password),
                inputType = InputType.PASSWORD,
                onValueChange = { confirmPassword = it }
            )

            TodoButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                text = stringResource(R.string.register),
                onClick = onRegister
            )
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        paddingValues = PaddingValues(),
        onNavigateToLogin = { },
        onRegister = { }
    )
}