package com.example.assignment15.messages

data class MessagesClass(
    val id: Int,
    val image: Int?,
    val owner: String,
    val lastMessage: String,
    val lastActive: String,
    val unreadMessages: Int?,
    val isTyping:Boolean,
    val lastMessageType: LastMessType
) {
    enum class LastMessType{
        VOICE,
        TEXT,
        FILE
    }
}
