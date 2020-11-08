package com.riztech.bus.domain.repository

interface HomeRepository {

    suspend fun getLines()
}