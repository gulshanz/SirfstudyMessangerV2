package com.gulshan.sirfstudymessanger.ui.home.chats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gulshan.sirfstudymessanger.repository.ChatRepository

class ChatViewModelProviderFactory(
    val chatRepository: ChatRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatViewModel(chatRepository) as T
    }
}