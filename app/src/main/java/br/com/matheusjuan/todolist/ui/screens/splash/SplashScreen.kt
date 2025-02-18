package br.com.matheusjuan.todolist.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.theme.BlueBase
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToNextScreen: () -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        delay(2_000)
        onNavigateToNextScreen()
    }

    Box(
        modifier = modifier
            .background(BlueBase)
            .fillMaxSize()
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Center)
                .size(90.dp),
            painter = painterResource(id = R.drawable.logo_todo),
            contentDescription = stringResource(id = R.string.app_logo),
            tint = Color.White
        )
        Icon(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
                .size(48.dp),
            painter = painterResource(id = R.drawable.logo_mj),
            tint = Color.White,
            contentDescription = stringResource(id = R.string.logo_mj)
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen { }
}