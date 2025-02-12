package br.com.matheusjuan.todolist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: String,
    val title: String,
    val description: String,
    val startAt: String,
    val endAt: String,
    val priority: Int,
    val done: Boolean,
    val idUser: String,
    val createdAt: String,
    val version: Int
)
