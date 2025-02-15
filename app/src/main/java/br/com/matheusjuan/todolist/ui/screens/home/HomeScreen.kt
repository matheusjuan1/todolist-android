package br.com.matheusjuan.todolist.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(

        ) {
            Text(
                text = "Bom dia Matheus"
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenListPreview() {
    HomeScreen()
}

@Preview
@Composable
private fun HomeScreenEmptyPreview() {
    HomeScreen()
}