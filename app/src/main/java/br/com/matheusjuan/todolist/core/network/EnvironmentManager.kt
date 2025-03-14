package br.com.matheusjuan.todolist.core.network

import br.com.matheusjuan.todolist.core.util.Constants

object EnvironmentManager {

    private const val IS_PROD = true

    val baseUrl: String
        get() = if (IS_PROD) Constants.BASE_URL_PROD else Constants.BASE_URL_DEV
}