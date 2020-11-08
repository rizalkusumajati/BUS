package com.riztech.bus.domain.repository

interface LoginRepository {

    suspend fun login(username: String, password: String)
}