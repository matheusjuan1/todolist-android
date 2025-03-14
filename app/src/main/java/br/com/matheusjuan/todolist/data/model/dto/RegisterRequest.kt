package br.com.matheusjuan.todolist.data.model.dto

data class RegisterRequest(
    val name: String,
    val username: String,
    val password: String
)