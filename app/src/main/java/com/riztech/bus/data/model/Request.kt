package com.riztech.bus.data.model

import com.google.gson.annotations.SerializedName

sealed class Request {

    data class Auth(
        @SerializedName("grant_type")
        val grantType: String = "password",
        val username: String? = null,
        val password: String? = null
    ): Request()

}