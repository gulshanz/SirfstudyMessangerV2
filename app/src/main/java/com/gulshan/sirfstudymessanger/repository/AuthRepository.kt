package com.gulshan.sirfstudymessanger.repository

import com.gulshan.sirfstudymessanger.network.api.AuthApi
import com.gulshan.sirfstudymessanger.network.api.RetrofitInstance.Companion.authApi
import com.gulshan.sirfstudymessanger.network.response.LoginResponse
import com.gulshan.sirfstudymessanger.util.Constants
import retrofit2.Response

class AuthRepository {

    suspend fun login(username: String, password: String): Response<LoginResponse>{
        return authApi.login(username, password)
    }
}