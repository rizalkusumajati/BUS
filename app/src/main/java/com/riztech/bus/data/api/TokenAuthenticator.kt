package com.riztech.bus.data.api

import com.riztech.bus.data.sp.LocalValue
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject


class TokenAuthenticator @Inject constructor(val api: BusApi) : Authenticator {

     override fun authenticate(route: Route?, response: Response): Request? {
        val refreshResult = refreshToken()
        return if (refreshResult) {
            //refresh is successful, we saved new token to storage
            // get your token from storage and set header

            // make current request with new access token
            response.request.newBuilder()
                .header("Authorization",  "${LocalValue.userData?.token_type + " " + LocalValue.userData?.access_token}")
                .build()
        } else {
            // Refresh token failed, you can logout user or retry couple times
            // Returning null is critical here, it will stop current request
            // If you do not return null, the request gets called again and again
            // You will end up in a loop calling refresh again and again
            null
        }
    }

    @Synchronized fun refreshToken(): Boolean {
        // you can use RxJava with Retrofit and add blockingGet
        // it is up to you how to refresh your token
        return runBlocking {
            val result = api.login("refresh","", "")
            val responseCode: Int = result.code()
            if (responseCode == 200) {
                LocalValue.userData = result.body()
                // save new token to sharedpreferences, storage etc.
                true
            } else {
                //cannot refresh
                false
            }
        }

    }
}