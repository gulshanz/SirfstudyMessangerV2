package com.gulshan.sirfstudymessanger.ui.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gulshan.sirfstudymessanger.databinding.ChatScreenBinding

class ChatScreen : AppCompatActivity() {
    lateinit var binding: ChatScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}