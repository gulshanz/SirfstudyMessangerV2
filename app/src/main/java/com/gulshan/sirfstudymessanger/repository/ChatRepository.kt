package com.gulshan.sirfstudymessanger.repository

import com.gulshan.sirfstudymessanger.network.api.RetrofitInstance.Companion.chatApi
import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import com.gulshan.sirfstudymessanger.network.response.group_chat.GroupChatResponse
import retrofit2.Response

class ChatRepository(){
     suspend fun getChats(): Response<AllChatsResponse> {
        return chatApi.getAllChats()
    }

    suspend fun getGroupChatList():Response<GroupChatResponse>{
        return chatApi.getGroupChatList()
    }
}