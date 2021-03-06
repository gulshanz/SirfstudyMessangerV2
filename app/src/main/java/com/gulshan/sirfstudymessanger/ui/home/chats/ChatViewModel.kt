package com.gulshan.sirfstudymessanger.ui.home.chats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import com.gulshan.sirfstudymessanger.repository.ChatRepository
import com.gulshan.sirfstudymessanger.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class ChatViewModel(
    val chatRepository: ChatRepository
) : ViewModel() {
    val chatList: MutableLiveData<Resource<AllChatsResponse>> = MutableLiveData()

    init {
        getAllChats()
    }

    private fun getAllChats() = viewModelScope.launch(Dispatchers.IO) {
        chatList.postValue(Resource.Loading())
        try {
            val response = chatRepository.getChats()
            chatList.postValue(handleChatResponse(response))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun handleChatResponse(response: Response<AllChatsResponse>): Resource<AllChatsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}