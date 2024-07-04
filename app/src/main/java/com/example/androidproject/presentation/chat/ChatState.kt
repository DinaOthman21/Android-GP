package com.example.androidproject.presentation.chat

import android.graphics.Bitmap
import com.example.androidproject.data.remote.chat.Chat

data class ChatState(
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
    val bitmap: Bitmap? = null
)