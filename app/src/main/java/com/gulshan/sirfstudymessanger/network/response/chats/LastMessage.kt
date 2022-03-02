package com.gulshan.sirfstudymessanger.network.response.chats

data class LastMessage(
    val chat_color: String,
    val deleted_one: String,
    val deleted_two: String,
    val file_size: Int,
    val from_id: String,
    val group_id: String,
    val id: String,
    val lat: String,
    val lng: String,
    val media: String,
    val mediaFileName: String,
    val mediaFileNames: String,
    val messageUser: MessageUser,
    val notification_id: String,
    val onwer: Int,
    val page_id: String,
    val position: String,
    val product: Any,
    val product_id: String,
    val seen: String,
    val sent_push: String,
    val stickers: String,
    val text: String,
    val time: String,
    val time_text: String,
    val to_id: String,
    val type: String,
    val type_two: String
)