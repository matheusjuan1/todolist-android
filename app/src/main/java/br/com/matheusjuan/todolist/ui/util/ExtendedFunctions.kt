package br.com.matheusjuan.todolist.ui.util

import android.content.Context
import androidx.compose.ui.graphics.Color
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.ui.theme.GreenBase
import br.com.matheusjuan.todolist.ui.theme.RedBase
import br.com.matheusjuan.todolist.ui.theme.YellowBase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


fun String.formatServiceDateTime(): String {
    val possibleFormats = listOf(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        "yyyy-MM-dd'T'HH:mm:ss'Z'",
        "yyyy-MM-dd HH:mm:ss"
    )

    for (format in possibleFormats) {
        try {
            val apiFormatter = DateTimeFormatter.ofPattern(format)

            val localDateTime = LocalDateTime.parse(this, apiFormatter)

            val uiFormatter = DateTimeFormatter.ofPattern("dd 'de' MMM, yyyy HH:mm")

            return localDateTime.format(uiFormatter)
        } catch (_: Exception) {
        }
    }
    return ""
}

fun Int.getPriorityInfo(context: Context): Pair<String, Color> {
    return when (this) {
        1 -> context.getString(R.string.low) to GreenBase
        2 -> context.getString(R.string.medium) to YellowBase
        3 -> context.getString(R.string.high) to RedBase
        else -> context.getString(R.string.low) to GreenBase
    }
}