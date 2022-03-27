package com.gulshan.sirfstudymessanger.network.api

import com.gulshan.sirfstudymessanger.util.Keys
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(Keys.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        val authApi by lazy {
            retrofit.create(AuthApi::class.java)
        }
        val chatApi by lazy {
            retrofit.create(ChatApi::class.java)
        }
    }
}