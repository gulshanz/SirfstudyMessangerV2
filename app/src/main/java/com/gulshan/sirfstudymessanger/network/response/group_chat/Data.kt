package com.gulshan.sirfstudymessanger.network.response.group_chat

data class Data(
    val avatar: String,
    val chat_time: String,
    val group_id: String,
    val group_name: String,
    val last_message: Any,
    val last_seen: List<Any>,
    val owner: Boolean,
    val parts: List<Part>,
    val time: String,
    val user_data: UserData,
    val user_id: String
)