package com.example.chatapp.chat.model

data class Chat (
    val messages: MutableList<Map<String, String>>
){
    fun addMessage(k: String, v: String) { messages.add(0, mapOf(k to v)) }
}