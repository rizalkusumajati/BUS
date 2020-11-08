package com.riztech.bus.data.api

import android.R.integer

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.*


class TokenInterceptor{//: Interceptor {
//    var mPrefs: SharedPreferences? = null
//    var mPrefsEdit: SharedPreferences.Editor? = null
//
//    @Throws(IOException::class)
//    override fun intercept(chain: Interceptor.Chain): Response {
//        var newRequest: Request = chain.request()
//
//        //get expire time from shared preferences
//        val expireTime = mPrefs!!.getLong("expiretime", 0)
//        val c: Calendar = Calendar.getInstance()
//        val nowDate: Date = c.getTime()
//        c.setTimeInMillis(expireTime)
//        val expireDate: Date = c.getTime()
//        val result: Int = nowDate.compareTo(expireDate)
//        // when comparing dates -1 means date passed so we need to refresh token
//        if (result == -1) {
//            //refresh token here , and get new access token
//            val tokenResponse: TokenResponse = refreshToken()
//
//            // Save refreshed token's expire time :
//            val expiresIn: Int = tokenResponse.getExpiresIn()
//            val c: Calendar = Calendar.getInstance()
//            c.add(Calendar.SECOND, expiresIn)
//            mPrefsEdit!!.putLong("expiretime", c.getTimeInMillis())
//            val newaccessToken = "new access token"
//            newRequest = chain.request().newBuilder()
//                .header("Authorization", newaccessToken)
//                .build()
//        }
//        return chain.proceed(newRequest)
//    }
}