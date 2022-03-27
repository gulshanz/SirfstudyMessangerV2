package com.gulshan.sirfstudymessanger.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gulshan.sirfstudymessanger.repository.AuthRepository

class AuthViewModelProviderFactory(
    val authRepository: AuthRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(authRepository) as T
    }
}