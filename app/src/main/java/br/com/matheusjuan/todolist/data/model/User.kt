package br.com.matheusjuan.todolist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val username: String,
    val name: String,
    val token: String,
    val createdAt: String
)
