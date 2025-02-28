package br.com.matheusjuan.todolist.ui.util.enums

import androidx.compose.ui.graphics.Color
import br.com.matheusjuan.todolist.ui.theme.GreenBase
import br.com.matheusjuan.todolist.ui.theme.RedBase
import br.com.matheusjuan.todolist.ui.theme.YellowBase

enum class Priority(
    val value: Int,
    val color: Color
) {
    LOW(1, GreenBase),
    MEDIUM(2, YellowBase),
    HIGH(3, RedBase);

    companion object {
        fun fromValue(value: Int): Priority {
            return entries.find { it.value == value } ?: LOW
        }
    }
}