package com.example.assignment15.messages


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment15.databinding.ItemMessagesLayoutBinding

class MessagesRecyclerAdapter :
    ListAdapter<MessagesClass, MessagesRecyclerAdapter.MessagesViewHolder>(Messages()) {

    inner class MessagesViewHolder(private val binding: ItemMessagesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var message: MessagesClass
        fun bind(){
            message = currentList[adapterPosition]
            with(binding){
                tvOwner.text = message.owner //dasamatebelia yvelaferi
            }
        }


    }

    class Messages : DiffUtil.ItemCallback<MessagesClass>() {

        override fun areItemsTheSame(oldItem: MessagesClass, newItem: MessagesClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessagesClass, newItem: MessagesClass): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MessagesViewHolder(
        ItemMessagesLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind()
    }
}