package com.example.androidproject.data.remote.chat

import android.graphics.Bitmap

data class Chat(
    val prompt: String,
    val bitmap: Bitmap?,
    val isFromUser :Boolean
)
