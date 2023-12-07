package com.example.assignment15.messages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MessagesFragmentViewModel : ViewModel() {
    private val _messagesFlow = MutableStateFlow<List<MessagesClass>>(emptyList())
    val messagesFlow: SharedFlow<List<MessagesClass>> = _messagesFlow.asStateFlow()

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
                    )
                )
            )
        }
    }
}