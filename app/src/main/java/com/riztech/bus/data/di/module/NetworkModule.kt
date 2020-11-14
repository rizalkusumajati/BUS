package com.riztech.bus.data.di.module

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import com.riztech.bus.BuildConfig
import com.riztech.bus.data.api.BusApi
import com.riztech.bus.data.api.TokenAuthenticator
import com.riztech.bus.data.sp.LocalValue
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkhttpClient(mainApp: Application, api: BusApi): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(ChuckInterceptor(mainApp))
            .addInterceptor {chain ->
                val original = chain.request()
                LocalValue.userData?.let {user->
                    if (!user.token_type.isEmpty() && !user.access_token.isEmpty()){
                        val newRequest = original.newBuilder()
                            .addHeader("Accept",   "application/vnd.bus.v1+json")
                            .addHeader("Authorization",  "${LocalValue.userData?.token_type + " " + LocalValue.userData?.access_token}")
                            .build()
                        chain.proceed(newRequest)
                    }else{
                        chain.proceed(original)
                    }

                }?: chain.proceed(original)

            }
            .authenticator(TokenAuthenticator(api))
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson{
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    @Named("bus_rest")
    fun provideRestClient(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideSportDbServices(@Named("bus_rest") restAdapter: Retrofit): BusApi {
        return restAdapter.create<BusApi>(BusApi::class.java)
    }
}