package br.com.matheusjuan.todolist.core.network.service

import br.com.matheusjuan.todolist.core.network.KtorHttpClient
import br.com.matheusjuan.todolist.data.model.User
import br.com.matheusjuan.todolist.data.model.dto.LoginRequest
import br.com.matheusjuan.todolist.data.model.dto.RegisterRequest
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface AuthService {

    suspend fun register(request: RegisterRequest): User

    suspend fun login(request: LoginRequest): User
}

class AuthServiceImpl : AuthService {

    override suspend fun register(request: RegisterRequest): User {
        return KtorHttpClient.client.post("${KtorHttpClient.baserUrl}/auth/register") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    override suspend fun login(request: LoginRequest): User {
        return KtorHttpClient.client.post("${KtorHttpClient.baserUrl}/auth/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}