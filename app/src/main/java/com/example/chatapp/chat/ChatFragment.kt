package com.example.chatapp.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.R
import com.example.chatapp.chat.adapter.ChatLayoutItemAdapter
import com.example.chatapp.chat.adapter.ChatMessageItemAdapter
import com.example.chatapp.chat.model.Chat
import kotlinx.android.synthetic.main.fragment_chat.view.*
import kotlinx.android.synthetic.main.fragment_chat_list.view.*
import kotlinx.android.synthetic.main.fragment_chat_list.view.ChatListRecyclerView


class ChatFragment : Fragment() {

    val chat = Chat(mutableListOf(
        mapOf("giorgi" to "how are you?"),
        mapOf("giorgi" to "i'am fine"),
        mapOf("me" to "how are you?"),
        mapOf("me" to "Hi"),
        mapOf("giorgi" to "Hello"),
    ))

    private lateinit var adapter: ChatMessageItemAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        adapter = ChatMessageItemAdapter(view.context, chat.messages)
        view.chatRecyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(context)

        layoutManager.reverseLayout = true
        view.chatRecyclerView.layoutManager = layoutManager
        view.chatRecyclerView.setHasFixedSize(true)

        view.chatSendImageButton.setOnClickListener { send() }

        return view
    }

    private fun send() {
        val view = requireView()
        val editText = view.chatMessageEditText
        if (editText.text.isNotEmpty()){
            chat.addMessage("me", editText.text.toString())
            editText.setText("")
            adapter.notifyItemInserted(0)
            view.chatRecyclerView.smoothScrollToPosition(0)
        }

    }

}