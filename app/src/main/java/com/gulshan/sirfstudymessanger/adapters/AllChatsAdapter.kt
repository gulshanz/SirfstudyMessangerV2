package com.gulshan.sirfstudymessanger.adapters

import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gulshan.sirfstudymessanger.R
import com.gulshan.sirfstudymessanger.network.response.chats.AllChatsResponse
import com.gulshan.sirfstudymessanger.network.response.chats.SingleChatItem

class AllChatsAdapter : RecyclerView.Adapter<AllChatsAdapter.ViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<SingleChatItem>() {
        override fun areItemsTheSame(oldItem: SingleChatItem, newItem: SingleChatItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: SingleChatItem, newItem: SingleChatItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_chat,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((SingleChatItem) -> Unit)? =null


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = differ.currentList[position]
        holder.apply {
            name.text = chat.name
            message.text = chat.about

        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(chat) }
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       var name:TextView
       var message:TextView

       init {
           name = itemView.findViewById(R.id.text_name)
           message = itemView.findViewById(R.id.text_message)
       }
    }

    fun setOnItemClickListener(listener:(SingleChatItem) ->Unit){
        onItemClickListener = listener
    }


}