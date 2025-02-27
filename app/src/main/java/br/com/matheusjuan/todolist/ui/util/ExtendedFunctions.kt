package br.com.matheusjuan.todolist.ui.util

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

            val uiFormatter = DateTimeFormatter.ofPattern("dd 'de' MMM yyyy HH:mm")

            return localDateTime.format(uiFormatter)
        } catch (_: Exception) {
        }
    }
    return ""
}