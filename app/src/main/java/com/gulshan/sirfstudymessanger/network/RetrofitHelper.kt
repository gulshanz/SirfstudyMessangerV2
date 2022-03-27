package com.gulshan.sirfstudymessanger.network

import com.google.gson.GsonBuilder
import com.gulshan.sirfstudymessanger.network.api.AuthApi
import com.gulshan.sirfstudymessanger.util.Keys.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {


    fun provideAuthApi(): AuthApi {
        return getInstance().create(AuthApi::class.java)
    }

    val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}