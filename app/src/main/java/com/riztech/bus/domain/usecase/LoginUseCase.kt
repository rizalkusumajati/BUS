package com.riztech.bus.domain.usecase

interface LoginUseCase {

    fun validateLoginForm(username: String, password: String)
    fun postLogin(username: String, password: String)
}