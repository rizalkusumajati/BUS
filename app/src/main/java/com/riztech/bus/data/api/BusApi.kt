package com.riztech.bus.data.api

import com.riztech.bus.data.model.BusApiResponse
import com.riztech.bus.data.model.Request
import retrofit2.Response
import retrofit2.http.*

interface BusApi {
    @POST("auth/token")
    suspend fun login(@Body auth: Request.Auth): Response<BusApiResponse.UserToken>

    @GET("lines")
    suspend fun getLines(@Query("page") page:Int, @Query("size") size: Int): Response<BusApiResponse.Lines>
}