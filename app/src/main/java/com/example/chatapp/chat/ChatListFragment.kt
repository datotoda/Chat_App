package com.example.chatapp.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import com.example.chatapp.R
import com.example.chatapp.chat.adapter.ChatLayoutItemAdapter
import com.example.chatapp.chat.model.ChatLayout
import kotlinx.android.synthetic.main.fragment_chat_list.view.*


class ChatListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat_list, container, false)

        val list = listOf(
            ChatLayout("https://scontent.ftbs4-2.fna.fbcdn.net/v/t1.6435-9/170198175_100728042140182_6750965491257972285_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=xQ2O-g-968cAX8f40K-&_nc_ht=scontent.ftbs4-2.fna&oh=00_AT8shjub2pe9jIJagah_ujvwuf0dUHw04uMWhrsu9d5P9w&oe=620E4FA7",
                "Giorgi",
                "you: Hello!"),
        )


        view.ChatListRecyclerView.adapter = ChatLayoutItemAdapter(view.context, list)
        view.ChatListRecyclerView.setHasFixedSize(true)

        return view
    }

}