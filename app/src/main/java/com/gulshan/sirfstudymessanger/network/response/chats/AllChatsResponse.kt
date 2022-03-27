package com.gulshan.sirfstudymessanger.network.response.chats

import java.io.Serializable

data class AllChatsResponse(
    val agora_call: Boolean,
    val agora_call_data: List<Any>,
    val api_status: Int,
    val audio_call: Boolean,
    val audio_call_user: List<Any>,
    val `data`: List<SingleChatItem>,
    val video_call: Boolean,
    val video_call_user: List<Any>
):Serializable