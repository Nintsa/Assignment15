package com.example.assignment15.messages

import com.squareup.moshi.Json
data class MessagesClass(
    val id: Int,
    val image: Int?,
    val owner: String,
    @Json(name="last_message")
    val lastMessage: String,
    @Json(name="last_active")
    val lastActive: String,
    @Json(name="unread_messages")
    val unreadMessages: Int?,
    @Json(name = "is_typing")
    val isTyping:Boolean,
    @Json(name = "laste_message_type")
    val lastMessageType: LastMessType
) {
    enum class LastMessType{
        VOICE,
        TEXT,
        FILE
    }
}
