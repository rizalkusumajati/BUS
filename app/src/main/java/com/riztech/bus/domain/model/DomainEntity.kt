package com.riztech.bus.domain.model

sealed class DomainEntity {

    data class Line(
        val id: String,
        val name: String,
        val ipAddress: String
    )

}