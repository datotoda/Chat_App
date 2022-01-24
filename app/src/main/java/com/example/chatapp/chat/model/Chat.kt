package com.example.chatapp.chat.model

data class Chat (
    val messages: MutableList<Map<String, String>>
){
    fun addMessage(k: String, v: String) { messages.add(mapOf(k to v)) }
}