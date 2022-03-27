package com.gulshan.sirfstudymessanger.network.response.group_chat

import com.gulshan.sirfstudymessanger.network.response.chats.SingleChatItem

data class GroupChatResponse(
    val api_status: Int,
    val `data`: List<SingleChatItem>
)