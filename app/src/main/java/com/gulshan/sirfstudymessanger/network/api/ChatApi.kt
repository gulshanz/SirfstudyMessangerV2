package com.gulshan.sirfstudymessanger.network.api

import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import com.gulshan.sirfstudymessanger.network.response.group_chat.GroupChatResponse
import com.gulshan.sirfstudymessanger.util.Constants.SERVER_KEY
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface ChatApi {
    @FormUrlEncoded
    @POST("get_chats")
    suspend fun getAllChats(
        @Query("access_token") access_token: String = SharedPref.getAccessToken().toString(),
        @Field("server_key") server_key: String = SERVER_KEY
    ): Response<AllChatsResponse>

    @FormUrlEncoded
    @POST("get_chats")
    suspend fun getOnlineUsers(
        @Query("access_token") access_token: String = SharedPref.getAccessToken().toString(),
        @Field("server_key") server_key: String = SERVER_KEY
    ): Response<AllChatsResponse>

    @FormUrlEncoded
    @POST("group_chat")
    suspend fun getGroupChatList(
        @Query("access_token") access_token: String = SharedPref.getAccessToken().toString(),
        @Field("server_key") server_key: String = SERVER_KEY,
        @Field("type") type: String = "get_list"
    ): Response<GroupChatResponse>
}