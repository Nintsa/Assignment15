package com.example.assignment15.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MessagesFragmentViewModel : ViewModel() {
    private val _messagesFlow = MutableSharedFlow<List<MessagesClass>>()
    val messagesFlow: SharedFlow<List<MessagesClass>> = _messagesFlow.asSharedFlow()

    fun addNewMessages(
    ) {
        viewModelScope.launch {
            _messagesFlow.emit(
                listOf(
                    MessagesClass(
                        id = 1,
                        image = null,
                        owner = "გრიშა ონიანი",
                        lastMessage = "თავის ტერიტორიას ბომბავდა",
                        lastActive = "4:20 PM",
                        unreadMessages = 3,
                        isTyping = false,
                        lastMessageType = MessagesClass.LastMessType.TEXT
                    ),
                    MessagesClass(
                        id = 2,
                        image = null,
                        owner = "Kninca",
                        lastMessage = "თავის ტერიტორიას ბომბავდა",
                        lastActive = "4:20 PM",
                        unreadMessages = 3,
                        isTyping = false,
                        lastMessageType = MessagesClass.LastMessType.TEXT
                    )
                )
            )
        }
    }
}