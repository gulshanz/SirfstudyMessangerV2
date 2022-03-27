package com.gulshan.sirfstudymessanger.ui.home.group

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gulshan.sirfstudymessanger.repository.ChatRepository

class GroupChatViewModelProviderFactory(
    val chatRepository: ChatRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroupChatViewModel(chatRepository) as T
    }
}