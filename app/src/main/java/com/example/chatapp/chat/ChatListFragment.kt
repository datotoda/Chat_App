package com.example.chatapp.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.R
import com.example.chatapp.chat.adapter.ChatLayoutItemAdapter
import com.example.chatapp.chat.model.ChatLayout
import kotlinx.android.synthetic.main.fragment_chat_list.view.*


class ChatListFragment : Fragment() {
    private val list = arrayListOf(
        ChatLayout("https://randomuser.me/api/portraits/men/9.jpg",
            "Jhon",
            "jhon: Hello!"),
        ChatLayout("https://randomuser.me/api/portraits/women/57.jpg",
            "Anna",
            "anna: Call me"),
        ChatLayout("https://randomuser.me/api/portraits/women/21.jpg",
            "Fiona",
            "fiona: Really??"),
        ChatLayout("https://randomuser.me/api/portraits/men/66.jpg",
            "George",
            "george: good luck"),
        ChatLayout("https://randomuser.me/api/portraits/women/90.jpg",
            "Nao",
            "you: hello"),
    )
    private lateinit var adapter: ChatLayoutItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat_list, container, false)

        adapter = ChatLayoutItemAdapter(view.context, list)
        view.ChatListRecyclerView.adapter = adapter
        view.ChatListRecyclerView.layoutManager = LinearLayoutManager(context)
        view.ChatListRecyclerView.setHasFixedSize(true)

        return view
    }

}