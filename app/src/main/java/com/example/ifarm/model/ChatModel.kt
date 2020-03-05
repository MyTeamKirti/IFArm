package com.example.ifarm.model

data class ChatModel(
    val result: List<ChatResult>
)

data class ChatResult(
    val _id: String,
    val userName: String,
    val message: String,
    val imagePath: Int,
    val createdAt: String
)