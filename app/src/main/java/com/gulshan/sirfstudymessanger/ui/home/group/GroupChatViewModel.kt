package com.gulshan.sirfstudymessanger.ui.home.group

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gulshan.sirfstudymessanger.network.response.group_chat.GroupChatResponse
import com.gulshan.sirfstudymessanger.repository.ChatRepository
import com.gulshan.sirfstudymessanger.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class GroupChatViewModel(
    val chatRepository: ChatRepository
) : ViewModel() {

    val groupChatList: MutableLiveData<Resource<GroupChatResponse>> = MutableLiveData()

    init {
        getGroupChats()
    }

    private fun getGroupChats() = viewModelScope.launch {
        groupChatList.postValue(Resource.Loading())
        try {
            val response = chatRepository.getGroupChatList()
            groupChatList.postValue(handleResponse(response))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun handleResponse(response: Response<GroupChatResponse>): Resource<GroupChatResponse>? {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}