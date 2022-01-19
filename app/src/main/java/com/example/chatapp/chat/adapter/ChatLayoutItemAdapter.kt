package com.example.chatapp.chat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chatapp.R
import com.example.chatapp.chat.model.ChatLayout
import kotlinx.android.synthetic.main.chat_list_item.view.*

class ChatLayoutItemAdapter (private val context: Context,
                             private val dataSet: ArrayList<ChatLayout>): RecyclerView.Adapter<ChatLayoutItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val chatListItemNameTextView: TextView = view.chatListItemNameTextView
        val chatListItemTextTextView: TextView = view.chatListItemTextTextView
        val chatListItemProfileImageView: ImageView = view.chatListItemProfileImageView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]

        holder.chatListItemNameTextView.text = item.personName
        holder.chatListItemTextTextView.text = item.personLastChat

        Glide.with(context)
            .load(item.profilePictureUrl)
            .centerCrop()
            .circleCrop()
            .into(holder.chatListItemProfileImageView)
    }

    override fun getItemCount(): Int = dataSet.size
}