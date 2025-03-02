package br.com.matheusjuan.todolist.ui.util

import android.content.Context
import androidx.compose.ui.graphics.Color
import br.com.matheusjuan.todolist.R
import br.com.matheusjuan.todolist.data.model.Task
import br.com.matheusjuan.todolist.data.model.TaskEdit
import br.com.matheusjuan.todolist.ui.util.enums.Priority
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
        Priority.LOW.value -> context.getString(R.string.low) to Priority.LOW.color
        Priority.MEDIUM.value -> context.getString(R.string.medium) to Priority.MEDIUM.color
        Priority.HIGH.value -> context.getString(R.string.high) to Priority.HIGH.color
        else -> context.getString(R.string.low) to Priority.LOW.color
    }
}

fun Task.toTaskEdit(): TaskEdit {
    return TaskEdit(
        id = this.id,
        title = this.title,
        description = this.description,
        startAt = this.startAt,
        endAt = this.endAt,
        priority = this.priority,
        done = this.done
    )
}