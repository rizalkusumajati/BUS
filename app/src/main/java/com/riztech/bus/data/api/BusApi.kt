package com.riztech.bus.data.api

import com.riztech.bus.data.model.BusApiResponse
import retrofit2.Response
import retrofit2.http.*

interface BusApi {
    @POST("user-sessions/token")
    @FormUrlEncoded
    suspend fun login(@Field("grant_type") grantType: String, @Field("username") username:String, @Field("password") password:String): Response<BusApiResponse.UserToken>

    @GET("lines")
    suspend fun getLines(@Query("page") page:Int, @Query("size") size: Int): Response<BusApiResponse.Lines>
}