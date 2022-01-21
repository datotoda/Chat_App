package com.example.chatapp.chat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Space
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.R
import com.example.chatapp.chat.model.ChatLayout
import kotlinx.android.synthetic.main.chat_list_item.view.*
import kotlinx.android.synthetic.main.chat_message_item.view.*


class ChatMessageItemAdapter (private val context: Context,
                             private val dataSet: MutableList<Map<String, String>>): RecyclerView.Adapter<ChatMessageItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val chatMessageItemProfileImageView: ImageView = view.chatMessageItemProfileImageView
        val chatLeftMessageItemTextTextView: TextView = view.chatLeftMessageItemTextTextView
        val chatLeftMessageItemCardView: CardView = view.chatLeftMessageItemCardView
        val chatRightMessageItemTextTextView: TextView = view.chatRightMessageItemTextTextView
        val chatRightMessageItemCardView: CardView = view.chatRightMessageItemCardView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_message_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        val sender = item.keys.first()
        if (sender == "me"){
            holder.chatRightMessageItemTextTextView.text = item[sender]

//            holder.chatRightMessageItemCardView.width holder.itemView.width
            holder.chatLeftMessageItemCardView.isVisible = false
            holder.chatMessageItemProfileImageView.isVisible = false
        } else {
            Glide.with(context)
                .load("https://randomuser.me/api/portraits/men/20.jpg")
                .centerCrop()
                .circleCrop()
                .into(holder.chatMessageItemProfileImageView)
            holder.chatLeftMessageItemTextTextView.text = item[sender]
            holder.chatRightMessageItemCardView.isVisible = false


        }


    }

    override fun getItemCount(): Int = dataSet.size
}